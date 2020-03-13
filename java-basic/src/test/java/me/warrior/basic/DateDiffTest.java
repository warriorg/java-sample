package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateDiffTest {

    @Test
    public void test() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        java.util.Date utilDate = new Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        java.sql.Time sqlTime = new Time(System.currentTimeMillis());
        java.sql.Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.print("util date:" + utilDate);
        System.out.println(" format:" + format.format(utilDate));
        System.out.print("sql date:" + sqlDate);
        System.out.println(" format:" + format.format(sqlDate));
        System.out.print("sql time:" + sqlTime);
        System.out.println(" format:" + format.format(sqlTime));
        System.out.print("timestamp:" + timestamp);
        System.out.println(" format:" + format.format(timestamp));

    }
}
