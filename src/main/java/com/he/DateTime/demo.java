package com.he.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

public class demo {
    public static void main(String[] args) {

        // //一个时间表示
        // String stringDate = "2020-01-02 22:00:00";
        //  //初始化三个时区
        // ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        // ZoneId timeZoneNY = ZoneId.of("America/New_York");
        // ZoneId timeZoneJST = ZoneOffset.ofHours(9);
        // //格式化器
        // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // // 使用的是timeZoneJST时区 相当于存的是timeZoneJST的时间表示
        // ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
        // //使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区
        // DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        // System.out.println(timeZoneSH.getId() + outputFormat.withZone(timeZoneSH).format(date));
        // System.out.println(timeZoneNY.getId() + outputFormat.withZone(timeZoneNY).format(date));
        // System.out.println(timeZoneJST.getId() + outputFormat.withZone(timeZoneJST).format(date));
       /* System.out.println(LocalDate.now().query());
        System.out.println(LocalDateTime.now());*/

        System.out.println("//查询是否是今天要举办生日");
        System.out.println(LocalDate.now().query(demo::isFamilyBirthday));

    }


    public static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(MONTH_OF_YEAR);
        int day = date.get(DAY_OF_MONTH);
        if (month == Month.FEBRUARY.getValue() && day == 17)
            return Boolean.TRUE;
        if (month == Month.SEPTEMBER.getValue() && day == 21)
            return Boolean.TRUE;
        if (month == Month.MAY.getValue() && day == 22)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
