package me.warrior.basic;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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

    @Test
    public void substring() {
        String str = "012345";
        System.out.println(str.substring(0, 2));
        System.out.println(str.substring(3, 4));
        System.out.println(str.substring(4, 5));
        System.out.println(str.substring(5, 6));
    }

    @Test
    public void endsWith() {
        System.out.println("币制".endsWith("我的币制"));
        System.out.println("我的币制".endsWith("币制"));
    }

    @Test
    public void splitTest() {
        String testStr = "142 中国";
        String[] vals = testStr.split("\\s");
        System.out.println(vals[0]);
    }

    @Test
    public void type() {
       System.out.println(BigDecimal.class.getSuperclass().getSimpleName());
    }
}
