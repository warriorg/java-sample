package me.warriorg.kafka.producer.batch;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class BatchProducer {
    private KafkaProducer<Integer, String> producer;

    public BatchProducer() {
        var properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 指定要批量发送的消息个数，默认16K
        properties.put("batch.size", 16384); // 16k
        // 指定积赞消息的时长， 默认值为0ms
        properties.put("linger.ms", 50);
        this.producer = new KafkaProducer<>(properties);
    }

    public void sendMsg() {
        for (int i =0; i < 50; i ++) {
            var record = new ProducerRecord<>("test", 0, i * 10, "test-" + i * 100);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.print("partition:" + metadata.partition());
                    System.out.print(",topic:" + metadata.topic());
                    System.out.println(",offset:" + metadata.offset());
                }
            });
        }
    }
}
