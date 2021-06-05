package me.warriorg.juc;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    private static double[] d;

    private static class ForkJoinTask extends RecursiveTask<Integer> {
        private int first;
        private int last;

        public ForkJoinTask(int first, int last) {
            this.first = first;
            this.last = last;
        }

        @Override
        protected Integer compute() {
            int subCount;
            if (last- first < 10) {
                subCount = 0;
                for (int i = first; i <= last; i++) {
                    if (d[i] < 0.5) subCount++;
                }
            } else {
                int mid = (first + last) >>> 1;
                ForkJoinTask left = new ForkJoinTask(first, mid);
                left.fork();
                ForkJoinTask right = new ForkJoinTask(mid + 1, last);
                right.fork();
                subCount = left.join();
                subCount += right.join();
            }
            return subCount;
        }
    }

    public static void main(String[]args){
        Random r = new Random();
        d = new double[10000000];
        for (int i = 0; i < d.length; i++) {
            d[i] = r.nextDouble();
        }


        int n= new ForkJoinPool().invoke(new ForkJoinTask(0,9999999));
        System.out.println("Found"+n+"values");}

}
