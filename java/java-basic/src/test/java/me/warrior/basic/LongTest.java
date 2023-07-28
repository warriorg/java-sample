package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

/**
 * @author gao shiyong
 * @since 2022/10/26 13:50
 */
public class LongTest {

    @Test
    public void test() {
        long val = System.currentTimeMillis();
        System.out.println(val);

        System.out.println(3000l * 86400000l);
        System.out.println(259200000000l);
        System.out.println(3000l * 86400000l + val);
    }
}
