package me.warriorg.activemq.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * 自定义broker
 */
public class BrokerServer {
    public static void main(String[] args) throws Exception {
        BrokerService brokerServer = new BrokerService();
        brokerServer.setUseJmx(Boolean.TRUE);
        brokerServer.addConnector("tcp://127.0.0.1:61616");
//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(System.getProperty("user.dir"));
//        brokerServer.setDataDirectory(System.getProperty("user.dir"));
        brokerServer.start();
    }
}
