package me.warrior.basic;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;

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

        System.out.println(new String(Base64.getDecoder().decode("5byg5LiJ6YeM5pav")));
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
    public void substringTest() {
        System.out.println("913205940662962116".substring(8, 17));
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

    @Test
    public void gbkToUtf8() throws UnsupportedEncodingException {
        String str = "伍伍";
        byte[] gbkBytes = str.getBytes("GBK");
        System.out.println("GBK");
        for (byte b : gbkBytes) {
            System.out.print(b + " ");
        }
        System.out.println("");
        System.out.println("UTF-8");
        byte[] bytes  = str.getBytes("UTF-8");
        for (byte b : bytes) {
            System.out.print(b + " ");
        }

        bytes = new byte[] {-20, -86, -20, -86, -76, -13, -56, -10};
        System.out.println("");

        String utf8Str = new String(bytes, "GBK");
        System.out.println(utf8Str);
        System.out.println("UTF-8");
        gbkBytes = utf8Str.getBytes();
        for (byte b : gbkBytes) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }
}
