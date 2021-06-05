package me.warrior.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LocalDateTest {

    @Test
    public void afterTest() {
        LocalDate a = LocalDate.of(2012, 6, 30);
        LocalDate b = LocalDate.of(2012, 7, 1);
        Assertions.assertTrue(a.isBefore(b));
        Assertions.assertFalse(a.isBefore(a));
        Assertions.assertFalse(b.isBefore(a));

        LocalDate ld = LocalDate.of(2020, 10, 12);
        Assertions.assertTrue(LocalDate.now().isAfter(ld));
    }
}
