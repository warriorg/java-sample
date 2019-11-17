package me.warriorg.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OrderThreadTest2 {
    private ReentrantLock lock = new ReentrantLock();
    Condition aCondition = lock.newCondition();
    Condition bCondition = lock.newCondition();




    public static void main(String[] args){
        OrderThreadTest2 test = new OrderThreadTest2();


        test.new AOutput().start();
        test.new BOutput().start();
    }

     class AOutput extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("A");

                    bCondition.signal();
                    aCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class BOutput extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("B");
                    aCondition.signal();
                    bCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }


}
