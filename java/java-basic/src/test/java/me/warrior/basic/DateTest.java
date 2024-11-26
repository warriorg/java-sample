package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        System.out.println(sdf.format(calendar.getTime()));
    }

    @Test
    void testLocalDate() {
        System.out.println(LocalDate.now());
    }

    @Test
    void addDaysTest() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(5, -0);
        Date t =  c.getTime();


        System.out.println(t);
    }

    @Test
    public void getTimeTest() {
       System.out.println(System.currentTimeMillis());

       long time = System.currentTimeMillis();
       time = time + 1000 * 60 * 60 * 24 * 60;
       System.out.println(time + 1000L * 60 * 60 * 24 * 60);
       System.out.println(new Date(time + 1000L * 60 * 60 * 24 * 60));
    }
}
