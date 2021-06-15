package me.warriorg.juc.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3,true);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();

        new Thread(consumer).start();


    }
}

class Producer implements Runnable {

    private  BlockingQueue<Integer> blockingQueue;
    private static int element = 0;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {
        try {
            while(element < 20) {
                System.out.println("生产元素："+element);
                blockingQueue.put(element++);
            }
        } catch (Exception e) {
            System.out.println("生产者在等待空闲空间的时候发生异常！");
            e.printStackTrace();
        }
        System.out.println("生产者终止了生产过程！");
    }
}
class Consumer implements Runnable {

    private  BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {
        try {
            while(true) {
                System.out.println("消费元素："+blockingQueue.take());
            }
        } catch (Exception e) {
            System.out.println("消费者在等待新产品的时候发生异常！");
            e.printStackTrace();
        }
        System.out.println("消费者终止了消费过程！");
    }
}