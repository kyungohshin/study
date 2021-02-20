package shin.kafka.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerWithMultiThread {
	private static String TOPIC_NAME = "test";
	private static String GROUP_ID = "testgroup";
	private static String BOOTSTRAP_SERVERS = "193.123.251.231:9092";
	private static int CONSUMER_COUNT = 3;
	private static List<ConsumerWorker> workerThreads = new ArrayList<>();

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new ShutdownThread());
		Properties configs = new Properties();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < CONSUMER_COUNT; i++) {
			ConsumerWorker worker = new ConsumerWorker(configs, TOPIC_NAME, i);
			workerThreads.add(worker);
			executorService.execute(worker);
		}
	}

	static class ShutdownThread extends Thread {
		@Override
		public void run() {
			workerThreads.forEach(ConsumerWorker::shutdown);
			System.out.println("Bye");
		}
	}
}
