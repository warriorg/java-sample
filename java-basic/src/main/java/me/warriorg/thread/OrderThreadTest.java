package me.warriorg.thread;

public class OrderThreadTest {

    public static void main(String[] args){
        OrderThreadTest test = new OrderThreadTest();

        Object lock = new Object();

        test.new Output(lock, "A").start();
        test.new Output(lock, "B").start();
    }

    class Output extends Thread{
        private Object lock;
        private String value;

        public Output(Object lock,String value) {
            this.lock = lock;
            this.value = value;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    try {
                        System.out.println(value);
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
