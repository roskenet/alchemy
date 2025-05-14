package de.roskenet.flxproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class FlxKafkaClient {

    private static final Producer PRODUCER = getProducer();

    private static Producer getProducer() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");

        kafkaProps.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        Producer producer = new KafkaProducer<String, String>(kafkaProps);
        return producer;
    }

    public static <T extends Sendable> void syncronousSend(T record) {

        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("test",
                        "SomeImportantMessage",
                        record.serialised());

        try {
            var response = PRODUCER.send(producerRecord).get();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
