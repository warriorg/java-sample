package me.warrior.basic;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    public void equalsTest() {
        Integer a1 = 128;
        int a2 = 128;
        boolean result = a1 == a2;

        System.out.println(result);
    }

}
