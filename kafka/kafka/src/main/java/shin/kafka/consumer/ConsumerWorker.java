package shin.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

// 멀티쓰레드
public class ConsumerWorker implements Runnable {
	private Properties prop;
	private String topic;
	private String threadName;
	private KafkaConsumer<String, String> consumer;

	ConsumerWorker(Properties prop, String topic, int number) {
		this.prop = prop;
		this.topic = topic;
		this.threadName = "consumer-thread-" + number;
	}

	@Override
	public void run() {
		consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Arrays.asList(topic));
		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(1000);
				for (ConsumerRecord<String, String> record : records) {
					System.out.println(threadName + " >> " + record.value());
				}
				consumer.commitSync();
			}
		} catch (WakeupException e) { // wakeup실행시, poll할때 Exception처리
			System.out.println(threadName + " trigger WakeupException");
		} finally {
			consumer.commitSync();
			consumer.close();
		}
	}

	public void shutdown() {
		consumer.wakeup();
	}
}
