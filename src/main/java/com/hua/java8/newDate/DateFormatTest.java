package com.hua.java8.newDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author huazai
 * @date 2019/8/29 14:48
 */
public class DateFormatTest {
    public static void main(String[] args) {
        /*
         * 格式化显示时间
         */
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(date.format(DateTimeFormatter.ISO_ORDINAL_DATE));
//        System.out.println(date.format(DateTimeFormatter.RFC_1123_DATE_TIME));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(date.format(formatter));
        System.out.println("=========================");

        String formatDate = "20190731";
        String formatDateOwn = "2019-07-31";
        System.out.println(LocalDate.parse(formatDate,DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDate.parse(formatDateOwn,formatter));
    }
}
