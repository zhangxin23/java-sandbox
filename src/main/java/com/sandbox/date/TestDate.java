package com.sandbox.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    }
}
