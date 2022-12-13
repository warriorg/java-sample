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


    @Test
    public void nullStrTest() {
        String val = "";
        BigDecimal decimal = new BigDecimal(val);
        System.out.println(decimal);
        val = null;
        new BigDecimal(val);
    }

    @Test
    public void halfUp() {
        BigDecimal value = new BigDecimal("1254.55500");
        BigDecimal target = value.setScale(2, RoundingMode.HALF_UP);
        Assertions.assertEquals(target, new BigDecimal("1254.56"));
        Assertions.assertEquals(2, target.scale());

        value = new BigDecimal("1254.554");
        target = value.setScale(2, RoundingMode.HALF_UP);
        Assertions.assertEquals(target, new BigDecimal("1254.55"));


        value = new BigDecimal("1254.5501");
        target = value.setScale(2, RoundingMode.CEILING);
        Assertions.assertEquals(target, new BigDecimal("1254.56"));
    }

    @Test
    public void refenceTest() {
        BigDecimal[] val = {new BigDecimal("100")};
        refence(val);
        System.out.println(val[0]);
        Assertions.assertEquals(val[0], new BigDecimal("90"));
    }

    public void refence(BigDecimal[] val) {
        val[0] = val[0].subtract(new BigDecimal("10"));
    }
}
