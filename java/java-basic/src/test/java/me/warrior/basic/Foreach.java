package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

public class Foreach {


    @Test
    public void largeToSmall() {
        Instant start = Instant.now();
        int val = 0;
        for (int i = 1; i < 10_000; i++) {
           for (int j = 1; j < 1000; j++) {
               for (int k = 1; k < 100; k++) {
                   val = i*j*k;
               }
           }
        }
        Instant finish = Instant.now();
        
        System.out.println("largeToSmall:" + val + " " + Duration.between(start, finish).toMillis());
    }

    @Test
    public void smallToLarge() {
        Instant start = Instant.now();
        int val = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 1000; j++) {
                for (int k = 1; k < 10_000; k++) {
                    val = i*j*k;
                }
            }
        }
        Instant finish = Instant.now();

        System.out.println("smallToLarge:" + val + " " + Duration.between(start, finish).toMillis());
    }
}
