package me.warriorg.juc.create;

public class ThreadCreateSecond implements Runnable {

    public void run() {
        System.out.println("Hello from a thread create second!");
    }

    public static void main(String[] args) {
        Thread  thread = new Thread(new ThreadCreateSecond());
        thread.start();
    }
}
