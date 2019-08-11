package me.warriorg.kafka.producer.one;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class OneProducer {

    /***
     * 第一个为范型为key的类型，第二个范型为消息本身的类型
     */
    private KafkaProducer<Integer, String> producer;

    public OneProducer() {
        var properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(properties);
    }

    public void sendMsg() {
        var record = new ProducerRecord<>("test", 0, 1, "test");
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                System.out.println("partition:" + metadata.partition());
                System.out.print(",topic:" + metadata.topic());
                System.out.println(",offset:" + metadata.offset());
            }
        });
    }
}
