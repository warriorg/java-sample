package me.warriorg.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author warrior
 */
public class Parallellimit {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        Counts count = new Counts();

        count.num = 0;

        for (int i = 0; i < 1000; i++) {
            MyRunnable runnable = new MyRunnable(count);
            pool.execute(runnable);
        }

        pool.shutdown();

    }

    public static class Counts {
        public long num;
    }

    private static class MyRunnable implements Runnable {
        private Counts count;

        public MyRunnable(Counts count) {
            this.count = count;
        }

        @Override
        public void run() {
            try {
                synchronized (count) {
                    count.num++;
                    if (count.num < 1000) {
                        System.out.println(count.num);
                        count.wait();
                    }

                    if (count.num == 1000) {
                        count.notifyAll();
                    }
                    System.out.println("并发量 count=" + count.num + ", thread:" + Thread.currentThread().getId() + "+" + Thread.currentThread().getName());
                }


            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }
    }

}