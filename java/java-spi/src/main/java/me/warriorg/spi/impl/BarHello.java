package me.warriorg.spi.impl;

import me.warriorg.spi.HelloInterface;

/**
 * @author warrior
 */
public class BarHello implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("bar");
    }
}
