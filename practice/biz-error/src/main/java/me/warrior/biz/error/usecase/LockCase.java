package me.warrior.biz.error.usecase;

import me.warrior.biz.error.lock.Interesting;

public class LockCase {

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }


}
