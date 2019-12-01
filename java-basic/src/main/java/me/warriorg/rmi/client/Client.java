package me.warriorg.rmi.client;

import me.warriorg.rmi.remote.Hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author warrior
 */
public class Client {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 8888;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
