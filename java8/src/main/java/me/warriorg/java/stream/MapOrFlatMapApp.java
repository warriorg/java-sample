package me.warriorg.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapOrFlatMapApp {

    /***
     * 将多个Stream连接成一个Stream，这时候不是用新值取代Stream的值，与map有所区别，这是重新生成一个Stream对象取而代之。
     * @param args
     */
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("world");

        Stream<Stream<Character>> result = words.stream().map(w -> characterStream(w));
        System.out.println("map:");
        result.forEach(it -> it.forEach(System.out::print));
        System.out.println("");

        Stream<Character> letters = words.stream().flatMap(w -> characterStream(w));
        System.out.println("flatMap:");
        letters.forEach(System.out::print);
    }

    public static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray())
            result.add(c);
        return result.stream();
    }
}
