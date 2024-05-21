package dev.warriorg.rabbit.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author gao shiyong
 * @since 2022/5/16 14:24
 */
public class Producer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
             channel.queueDeclare(QUEUE_NAME, false, false, false, null);
             String message = "Hello World!";
             channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
             System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
