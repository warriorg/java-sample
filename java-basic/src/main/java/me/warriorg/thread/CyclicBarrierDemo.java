package me.warriorg.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/***
 * CyclicBarrier也叫同步屏障，在JDK1.5被引入，可以让一组线程达到一个屏障时被阻塞，直到最后一个线程达到屏障时，所以被阻塞的线程才能继续执行。
 * CyclicBarrier好比一扇门，默认情况下关闭状态，堵住了线程执行的道路，直到所有线程都就位，门才打开，让所有线程一起通过。
 */
public class CyclicBarrierDemo {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(8);

    public void start() {
        List<Athlete> athleteList = new ArrayList<>();
        athleteList.add(new Athlete(cyclicBarrier,"博尔特"));
        athleteList.add(new Athlete(cyclicBarrier,"鲍威尔"));
        athleteList.add(new Athlete(cyclicBarrier,"盖伊"));
        athleteList.add(new Athlete(cyclicBarrier,"布雷克"));
        athleteList.add(new Athlete(cyclicBarrier,"加特林"));
        athleteList.add(new Athlete(cyclicBarrier,"苏炳添"));
        athleteList.add(new Athlete(cyclicBarrier,"路人甲"));
        athleteList.add(new Athlete(cyclicBarrier,"路人乙"));
        Executor executor = Executors.newFixedThreadPool(8);
        for (Athlete athlete : athleteList) {
            executor.execute(athlete);
        }
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        demo.start();
    }

    class Athlete implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Athlete(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "就位");
            try {
                cyclicBarrier.await();
                Random random =new Random();
                double time = random.nextDouble() + 9;
                System.out.println(name + ": "+ time);
            } catch (Exception e) {
            }
        }
    }
}
