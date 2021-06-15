package me.warriorg.juc.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/***
 * SynchronousQueue是一个没有数据缓冲的BlockingQueue，生产者线程对其的插入操作put必须等待消费者的移除操作take，反过来也一样。
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
