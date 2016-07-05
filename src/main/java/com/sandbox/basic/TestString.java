package com.sandbox.basic;

/**
 * Created by zhangxin on 16/1/27.
 */
public class TestString {
    String name;

    public TestString(String personName) {
        name = personName;
    }

    public String greet(String yourName) {
        return String.format("Hi %s, my name is %s", name, yourName);
    }

    public static void setString(String out) {
        out = "setString func";
    }

    public static void main(String ... args) {
        System.out.println(new TestString("first").greet("1"));

        String out = "123";
        setString(out);
        System.out.println(out);

        String txt = "确认收货后,可获得1张{}元商家代金券";
        txt = txt.replace("{}", 0.9 + "");
        System.out.println(txt);


        /**
         * null可以被强制类型转换,而且可以被字符串中使用,null的字符串值为null.
         * */
        String testNull = (String)null;
        String sumString = "prifix" + testNull;
        System.out.println("testNull: " + sumString);

        Integer testIntNull = (Integer)null;
//        int sum = 1 + testIntNull;
        System.out.println("testIntNull: " + testIntNull);

        /**
         * 条件运算符的返回值只能有一个统一的类型,不是冒号前后可返回不同的类型.
         * */
        double value = 10.0;
        System.out.println("value: " + (value > 8.0 ? (long)value + "" : value + ""));

        System.out.println("======================================================================");

        String logStr = "[{\"utm_channel\":\"123\",\"dType\":\"vivo Y37L\",\"dId\":\"867839029781088\",\"dVersion\":\"21_5.0.2\",\"appName\":\"美团外卖\",\"customerId\":476982796,\"uuid\":\"691C802B0F002ADA7F9EDD9C6C5B1413B67514E74017336A169387A23C769237\",\"code\":20000191,\"result\":null,\"action\":\"点击外卖入口\",\"category\":\"click\",\"time\":1467043365,\"appCode\":401,\"appVersion\":\"7.0.1\",\"logType\":\"C\",\"cType\":\"mtandroid\",\"info\":\"\",\"DandelionMainChannel\":\"bbk\",\"utm_campaign\":\"\",\"channel\":\"vivo4\",\"latitude\":2.6559262E7,\"longitude\":1.0665795E8,\"address\":\"贵州理工学院\"}]";
        if(!logStr.matches(".*\"channel\":\"(\\d+)\".*")) {
            logStr = logStr.replace("\"channel\"", "\"utm_source\"");
        }

        System.out.println(logStr);
    }
}
