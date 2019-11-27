package me.warrior.basic;


import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void test() {
        String a = "a";
        String b = "a";
        String c = new String("a");
        String d = new String("a").intern();

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
    }
}
