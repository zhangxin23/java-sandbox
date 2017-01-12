package com.sandbox.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Author: zhangxin
 * Date:   15-11-18
 */
public class TestDate {
    public static final String DATE_FORMAT = "dd/MMM/yyyy:HH:mm:ssZ";

    public static long parse(String input){
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            Date d = format.parse(input);
            return d.getTime();
        } catch (ParseException ex) {
            throw new IllegalArgumentException("invalid date string");
        }
    }


    public static void main(String[] args) {
//        System.out.println(parse("24/Mar/2014:06:33:04 +0100"));

        try {
            SimpleDateFormat myFmt1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ssZ", Locale.ENGLISH);
            System.out.println(myFmt1.parse("24/Mar/2014:06:33:04+0800"));
//            System.out.println(myFmt1.format(new Date()));
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid format.");
        }

        Date date = new Date(0);
        String viewTime = new SimpleDateFormat("YYYY-M-d HH:mm").format(date);
        System.out.println("view_time = " + viewTime);


        Date date1 = new Date(0);
        String viewtime = new SimpleDateFormat("YYYY.MM.dd").format(date1);
        System.out.println("view_time_1=" + viewtime);




        System.out.println("########################################");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println(calendar.getTime());
        System.out.println("########################################");
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) + 1, 0, 0, 0);
        System.out.println(calendar.getTime());


        /*************************************/
        System.out.println("########################################");
        int now = (int)(System.currentTimeMillis() / 1000);
        int now7 = getNaturalDays(now, 7);
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTimeInMillis(now * 1000L);
        System.out.println(calendarNow.getTime());
        calendarNow.setTimeInMillis(now7 * 1000L);
        System.out.println(calendarNow.getTime());
    }

    public static int getNaturalDays(int sec, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sec * 1000L);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return (int)(calendar.getTimeInMillis() / 1000) + (days - 1) * 24 * 3600;
    }
}
