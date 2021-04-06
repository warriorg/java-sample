package me.warrior.basic;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
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
    public void getTimeTest() {
       System.out.println(System.currentTimeMillis());

    }
}
