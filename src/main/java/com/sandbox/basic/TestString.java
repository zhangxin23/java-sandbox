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
    }
}
