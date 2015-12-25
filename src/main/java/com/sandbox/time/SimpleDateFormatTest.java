package com.sandbox.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: zhangxin
 * Date:   15-12-25
 */
public class SimpleDateFormatTest {

    public static void main(String ... args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = dateFormat.parse("2015-12-25 17:00:00 cst");
        System.out.println(date.toString());
    }
}
