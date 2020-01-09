package me.warriorg.design.creational.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class SingletonTest {


    @Test
    public void createInstancePerformance() {

        long startTime = System.currentTimeMillis();
        Stream.iterate(1L, i -> i +1).limit(10000).parallel().forEach(it -> {
            SyncSingleton.getInstance();
        });
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        startTime = System.currentTimeMillis();
        Stream.iterate(1L, i -> i +1).limit(10000).parallel().forEach(it -> {
            StaticSingleton.getInstance();
        });
        endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }



}
