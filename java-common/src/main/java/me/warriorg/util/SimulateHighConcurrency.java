package me.warriorg.util;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

/**
 * @author warrior
 */
public class SimulateHighConcurrency {

    public static void run(int num, Consumer<Thread> action) {
        Objects.requireNonNull(action);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                try {
                    action.accept(Thread.currentThread());
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        //线程创建完成之后同时启动
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(2000);
        SimulateHighConcurrency.run(2000, (t) -> {
            System.out.println(t.getName());
            doneSignal.countDown();
        });
        doneSignal.await();
        System.out.println("done");
    }

}
