package me.warriorg.kafka.producer.batch;

import me.warriorg.kafka.producer.one.OneProducer;

import java.io.IOException;

public class BatchProducerTest {
    public static void main(String[] args) throws IOException {
        BatchProducer producer = new BatchProducer();
        producer.sendMsg();
        System.in.read();
    }
}
