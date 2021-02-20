package shin.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerWithSyncCommit {
	private static String TOPIC_NAME = "test";
	private static String GROUP_ID = "testgroup";
	private static String BOOTSTRAP_SERVERS = "193.123.251.231:9092";

	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false); // 오토커밋을 하지않음

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs);
		consumer.subscribe(Arrays.asList(TOPIC_NAME));

		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1000);
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(record.value());
				consumer.commitSync();
				record.offset();
			}
		}
	}
}
