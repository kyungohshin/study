package shin.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * key, value를 특정파티션에 지정하여 넣어서 카프카에 발행
 */
public class ProducerExactParition {
	private static String TOPIC_NAME = "test";
	private static String BOOTSTRAP_SERVERS = "193.123.251.231:9092";
	private static int PARTITION_NUMBER = 1;

	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

		for (int index = 0; index < 10; index++) {
			String data = "This is record " + index;
			ProducerRecord<String, String> record =
			        new ProducerRecord<>(TOPIC_NAME, PARTITION_NUMBER, Integer.toString(index), data);
			try {
				producer.send(record);
				System.out.println("Send to " + TOPIC_NAME + " | data : " + data);
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
