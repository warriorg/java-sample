package me.warrior.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal b1 = new BigDecimal("12.22223").setScale(2, RoundingMode.HALF_UP);
        System.out.println(b1);
        Assertions.assertEquals(b1, new BigDecimal("12.22"));
    }
}
