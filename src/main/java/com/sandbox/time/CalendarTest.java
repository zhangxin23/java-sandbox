package com.sandbox.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: zhangxin
 * Date:   15-12-29
 */
public class CalendarTest {

    public static void main(String ... args) throws ParseException {
        Calendar now = Calendar.getInstance();
        System.out.println("年: " + now.get(Calendar.YEAR));
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分: " + now.get(Calendar.MINUTE));
        System.out.println("秒: " + now.get(Calendar.SECOND));
        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
        System.out.println(now.getTime());

        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);

        String str = "2012-1-13 17:26:33";  //要跟上面sdf定义的格式一样
        Date today = sdf.parse(str);
        System.out.println("字符串转成日期：" + today);


        Calendar calendar = Calendar.getInstance();
        System.out.println("year: " + calendar.get(Calendar.YEAR));
        System.out.println("month: " + calendar.get(Calendar.MONTH));
        System.out.println("day: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("day of week: " + calendar.get(Calendar.DAY_OF_WEEK));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.set(year, month, day_of_month, 9, 30, 0);
        long amStart = calendar.getTimeInMillis();
        System.out.println(calendar.getTimeInMillis());

    }
}
