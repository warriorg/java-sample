package me.warrior.basic;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String str = "0615IE";
        System.out.println(str.substring(0, 4));
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

        System.out.println("==============================");
        String dateStr = "xxxx@yyymmm@xxx";
        vals = dateStr.split("@");
        Arrays.stream(vals).forEach(System.out::println);
        System.out.println("==============================");
        dateStr = "xxxx@";
        vals = dateStr.split("@");
        Arrays.stream(vals).forEach(System.out::println);
    }

    @Test
    public void type() {
       System.out.println(BigDecimal.class.getSuperclass().getSimpleName());
    }


    @Test
    public void java12NewMethod() {
        assertEquals("  ".isBlank(), true);
        assertEquals("Twinkle ".repeat(2),"Twinkle Twinkle ");
        assertEquals("Format Line".indent(4), "    Format Line\n");
        assertEquals(" Text with white spaces   ".strip(),"Text with white spaces");
        assertEquals("Car, Bus, Train".transform(s1 -> Arrays.asList(s1.split(","))).get(0), "Car");
    }
}
