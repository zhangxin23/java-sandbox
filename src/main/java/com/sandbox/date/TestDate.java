package com.sandbox.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println(parse("24/Mar/2014:06:33:04 +0100"));
    }
}
