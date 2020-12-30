package com.sandbox.java8.chaper12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.Locale;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/28 15:26
 */
public class MainDriver {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 7, 28);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean isLeap = date.isLeapYear();
        System.out.println("year: " + year + ", month: " + month + ", day: " + day);

        System.out.println("year: " + date.get(ChronoField.YEAR) + ", month: " + date.get(ChronoField.MONTH_OF_YEAR) +
                ", day: " + date.get(ChronoField.DAY_OF_MONTH));

        System.out.println("----------------------------------------------");

        LocalTime time = LocalTime.of(15, 33, 00);
        System.out.println("hour: " + time.getHour() + ", minute: " + time.getMinute() + ", second: " + time.getSecond());

        System.out.println("----------------------------------------------");
        LocalDateTime dateTime = LocalDateTime.of(2020, 7, 28, 15, 35, 00);
        System.out.println("year: " + dateTime.getYear() +
                            "\nmonth: " + dateTime.getMonth() +
                            "\nday: " + dateTime.getDayOfMonth() +
                            "\nhour: " + dateTime.getHour() +
                            "\nminute: " + dateTime.getMinute() +
                            "\nsecond: " + dateTime.getSecond());

        System.out.println("----------------------------------------------");
        System.out.println(Instant.now().getEpochSecond());

        System.out.println("----------------------------------------------");
        Duration duration = Duration.between(LocalTime.of(15, 00, 00), LocalTime.of(15, 30, 00));
        System.out.println("diff minutes: " + duration.toMinutes());

        Period period = Period.between(LocalDate.of(2020, 7, 20), LocalDate.of(2020, 7, 28));
        System.out.println("diff days: " + period.getDays());

        System.out.println("----------------------------------------------");
        LocalDate localDate = LocalDate.of(2020, 7, 28);
        LocalDate localDate1 = localDate.withYear(2022);
        LocalDate localDate2 = localDate1.withDayOfMonth(1);
        LocalDate localDate3 = localDate2.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println("year: " + localDate3.getYear() + ", month: " + localDate3.getMonth() + ", day: " + localDate3.getDayOfMonth());

        System.out.println("----------------------------------------------");
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date1 = LocalDate.of(2020, 7, 28);
        System.out.println(date1.format(italianFormatter));

        System.out.println("----------------------------------------------");
        LocalDate date2 = LocalDate.parse("2020-07-28", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("year: " + date2.getYear() + ", month: " + date2.getMonth().getValue() + ", day: " + date2.getDayOfMonth());

    }
}
