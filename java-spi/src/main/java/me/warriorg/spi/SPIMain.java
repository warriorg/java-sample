package me.warriorg.spi;

import java.util.ServiceLoader;

/**
 * @author warrior
 */
public class SPIMain {


    public static void main(String[] args) {
        ServiceLoader<HelloInterface> loaders = ServiceLoader.load(HelloInterface.class);
        if (loaders != null) {
            loaders.forEach(it -> {
                it.sayHello();
            });
        }
    }
}
