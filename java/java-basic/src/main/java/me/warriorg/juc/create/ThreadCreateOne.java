package me.warriorg.juc.create;

public class ThreadCreateOne extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) {
        Thread  thread = new ThreadCreateOne();
        thread.start();
    }
}
