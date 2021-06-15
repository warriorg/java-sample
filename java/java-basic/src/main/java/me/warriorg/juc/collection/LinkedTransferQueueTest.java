package me.warriorg.juc.collection;

import java.util.concurrent.LinkedTransferQueue;

/***
 * LinkedTransferQueue是一个由链表结构组成的无界阻塞TransferQueue队列。
 * 相对于其他阻塞队列LinkedTransferQueue多了tryTransfer和transfer方法。
 */
public class LinkedTransferQueueTest {
    public static void main(String[] args) {

        LinkedTransferQueue<Integer> blockingQueue = new LinkedTransferQueue<Integer>();
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
