package me.warriorg.kafka.producer.one;

import java.io.IOException;

public class OneProducerTest {

    public static void main(String[] args) throws IOException {
        OneProducer producer = new OneProducer();
        producer.sendMsg();
        System.in.read();
    }
}
