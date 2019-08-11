package me.warriorg.kafka.consumer.manual;

public class SyncManualConsumerTest {
    public static void main(String[] arg) {
        SyncManualConsumer consumer = new SyncManualConsumer();
        consumer.start();
    }
}
