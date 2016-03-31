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
    }
}
