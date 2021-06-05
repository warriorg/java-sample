package me.warriorg.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


/**
 什么是CAS
 （1）CAS(compare and swap) 比较并替换，比较和替换是线程并发算法时用到的一种技术
 （2）CAS是原子操作，保证并发安全，而不是保证并发同步
 （3）CAS是CPU的一个指令
 （4）CAS是非阻塞的、轻量级的乐观锁
 为什么说CAS是乐观锁
 乐观锁，严格来说并不是锁，通过原子性来保证数据的同步，比如说数据库的乐观锁，通过版本控制来实现等，所以CAS不会保证线程同步。乐观的认为在数据更新期间没有其他线程影响
 CAS原理
 CAS(compare and swap) 比较并替换，就是将内存值更新为需要的值，但是有个条件，内存值必须与期望值相同。举个例子，期望值 E、内存值M、更新值U，当E == M的时候将M更新为U。
 CAS应用
 由于CAS是CPU指令，我们只能通过JNI与操作系统交互，关于CAS的方法都在sun.misc包下Unsafe的类里
 java.util.concurrent.atomic包下的原子类等通过CAS来实现原子操作。
 */
public class CASLock {

    private static final CountDownLatch latch = new CountDownLatch(5);
    private static AtomicInteger i = new AtomicInteger(0);
    private static int p = 0;

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 5; j++) {
            pool.execute(() -> {
                for (int k = 0; k < 10000; k++) {
                    p++;                //不是原子操作
                    i.getAndIncrement();//调用原子类加1
                }
                latch.countDown();
            });
        }
        latch.await();//保证所有子线程执行完成
        System.out.println(System.currentTimeMillis() - time);
        System.out.println("p=" + p);
        System.out.println("i=" + i);
        pool.shutdown();
    }

}
