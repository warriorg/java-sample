package me.warrior.basic;

import java.time.LocalDate;
import java.time.YearMonth;

import org.junit.jupiter.api.Test;

class TimeTest {

    @Test
    void testYearMonth() {

        System.out.println(YearMonth.now());
        System.out.println(LocalDate.now());
    }

}
