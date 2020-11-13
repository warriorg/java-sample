package me.warriorg.kafka.consumer.test1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class OneConsumer {
    private KafkaConsumer<Integer, String> consumer;

    public OneConsumer() {
        Properties properties = new Properties();
        String brokers = "127.0.0.1:9092";
        properties.put("bootstrap.servers", brokers);
        // 指定消费者组ID
        properties.put("group.id", "testGroup1");
        // 开启offset自动提交
        properties.put("enable.auto.commit", "true");
        // 指定自动提交的最晚时间间隔
        properties.put("auto.commit.interval.ms", "1000");
        // 指定broker认定consumer宕机的时限。从consumer读取消息开始计时，一直到其收到consumer
        // 提交的offset， 这个时间段不能超过该值，否则broker认定当前consumer宕机
        properties.put("session.timeout.ms", "30000");
        // 消费者向broker controller发送心跳的频率 一般为session.timeout.ms的1/3
        properties.put("heartbeat.interval.ms", "10000");
        // 若没有指定初始的offset或指定的offset不存在，则offset则要读取其自定的默认值
        // earliest： 从partition的最开始的offset开始
        // lastest: 从该partition的最后offset开始，即HW
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(properties);
    }

    public void doWork() {
        consumer.subscribe(Collections.singleton("test"));
        // poll 是阻塞方法，若broker中没有消息，该poll等待的最长时间
        // 到时仍没有消息，则返回 null
        var records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord record : records) {
            System.out.print("topic=" + record.topic());
            System.out.print(" partition=" + record.partition());
            System.out.print(" key=" + record.key());
            System.out.println(" value=" + record.value());
        }
    }
}
