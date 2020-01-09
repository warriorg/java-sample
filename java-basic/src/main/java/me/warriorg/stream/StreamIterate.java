package me.warriorg.stream;

import java.util.stream.Stream;

/**
 * @author warrior
 */
public class StreamIterate {


    public static void main(String[] args) {
        int count = Stream.iterate(1,  i -> i + 1).limit(100).parallel().reduce(0, (a, b) -> a + b);
        System.out.println(count);
    }
}
