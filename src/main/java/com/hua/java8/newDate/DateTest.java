package com.hua.java8.newDate;

import java.time.*;
import java.util.Date;

/**
 * @author huazai
 * @date 2019/8/28 16:39
 */
public class DateTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 老的API
         */
        Date date = new Date(116,2,18);
        System.out.println(date);
        System.out.println("====================");

        /*
         * LocalDate
         */
        LocalDate localDate = LocalDate.of(2016,3,21);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());
        System.out.println("====================");

        /*
         * LocalTime
         */
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println("====================");

        /*
         * LocalDateTime(结合LocalDate和LocalTime)
         */
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.toString());
        System.out.println("====================");

        /*
         * Instant
         * Duration 时间段 Duration类主要用于以秒和纳秒衡量时间的长短
         */
        Instant start = Instant.now();
        Thread.sleep(1000L);
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration.toMillis());
        System.out.println("====================");

        /*
         * Period 如果你需要以年、月或者日的方式对多个时间单位建模，可以使用Period
         */
        Period period = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2016, 4, 19));
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());

    }
}
