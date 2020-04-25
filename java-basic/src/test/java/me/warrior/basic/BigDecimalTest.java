package me.warrior.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal b1 = new BigDecimal("12.22223").setScale(2, RoundingMode.UP);
        System.out.println(b1);
        Assertions.assertEquals(b1, new BigDecimal("12.23"));

        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(new BigDecimal("0.01035")));
    }
}
