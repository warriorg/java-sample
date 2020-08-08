package me.warriorg.java.performance.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("v1/api/mock")
public class MockController {

    /**
     * 模拟CPU占满
     */
    @GetMapping("/cpu/loop")
    public void testCPULoop() {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }

    /**
     * 模拟内存泄漏加
     * 启动参数
     * java -jar -Xms500m -Xmx500m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:/tmp/heaplog.log
     *
     */
    @GetMapping(value = "/memory/leak")
    public String leak() {
        System.out.println("模拟内存泄漏");
        ThreadLocal<Byte[]> localVariable = new ThreadLocal<>();
        // 为线程添加变量
        localVariable.set(new Byte[4096 * 1024]);
        return "ok";
    }


    ExecutorService service = new ThreadPoolExecutor(4, 10,
            0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    /**
     * 模拟死锁
     */
    @GetMapping("/cpu/test")
    public String testCPU() throws InterruptedException {
        System.out.println("请求cpu");
        Object lock1 = new Object();
        Object lock2 = new Object();
        service.submit(new DeadLockThread(lock1, lock2), "deadLookThread-" + new Random().nextInt());
        service.submit(new DeadLockThread(lock2, lock1), "deadLookThread-" + new Random().nextInt());
        return "ok";
    }

    public class DeadLockThread implements Runnable {
        private Object lock1;
        private Object lock2;

        public DeadLockThread(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName()+"get lock2 and wait lock1");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+"get lock1 and lock2 ");
                }
            }
        }
    }

    @GetMapping(value = "/thread/swap")
    public String theadSwap(int num) {
        System.out.println("模拟线程切换");
        for (int i = 0; i < num; i++) {
            new Thread(new ThreadSwap1(new AtomicInteger(0)),"thread-swap"+i).start();
        }
        return "ok";
    }
    public class ThreadSwap1 implements Runnable {
        private AtomicInteger integer;

        public ThreadSwap1(AtomicInteger integer) {
            this.integer = integer;
        }

        @Override
        public void run() {
            while (true) {
                integer.addAndGet(1);
                Thread.yield(); //让出CPU资源
            }
        }
    }

}
