package me.warriorg.design.creational.singleton;

import me.warrior.common.util.SimulateHighConcurrency;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
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

    @Test
    public void createInstancePerformancConcurrencye() throws InterruptedException {

        int num = 4000;

        CountDownLatch doneSignal = new CountDownLatch(num);
        long startTime = System.currentTimeMillis();
        SimulateHighConcurrency.run(num, (t) -> {
            SyncSingleton.getInstance();
            doneSignal.countDown();
        });
        doneSignal.await();
        long endTime = System.currentTimeMillis();
        System.out.println("SyncSingleton程序运行时间： " + (endTime - startTime) + "ms");

        CountDownLatch finalDoneSignal = new CountDownLatch(num);
        startTime = System.currentTimeMillis();
        SimulateHighConcurrency.run(num, (t) -> {
            StaticSingleton.getInstance();
            finalDoneSignal.countDown();
        });
        doneSignal.await();
        endTime = System.currentTimeMillis();
        System.out.println("StaticSingleton程序运行时间： " + (endTime - startTime) + "ms");
    }


}
