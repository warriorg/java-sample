package me.warriorg.kafka.consumer.manual;

import me.warriorg.kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class SyncManualConsumer extends ShutdownableThread {
    private KafkaConsumer<Integer, String> consumer;

    public SyncManualConsumer() {
        super("KafkaConsumerTest", false);
        Properties properties = new Properties();
        String brokers = "127.0.0.1:9092";
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "testManual");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        this.consumer = new KafkaConsumer<Integer, String>(properties);
    }

    @Override
    public void execute() {
        consumer.subscribe(Collections.singleton("test"));
        // poll 是阻塞方法，若broker中没有消息，该poll等待的最长时间
        // 到时仍没有消息，则返回 null
        var records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord record : records) {
            System.out.print("topic=" + record.topic());
            System.out.print(" partition=" + record.partition());
            System.out.print(" key=" + record.key());
            System.out.println(" value=" + record.value());

            consumer.commitSync();

            // 异步提交，失败后同步提交
//            try {
//                consumer.commitAsync((offsets, e) -> {
//                    if (e != null) {
//                        System.out.println(e.getMessage());
//                    }
//                });
//            } catch (Exception e) {
//                consumer.commitSync();
//            }

        }
    }
}

