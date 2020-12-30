package com.sandbox.java8.chapter9;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/27 14:43
 */
public interface DefaultMethod {
    int status = 1;

    void accept(String value);

    default void show(String value) {
        System.out.println("default method: " + value);
    }

    static void showShow(String value) {
        System.out.println("static method: " + value);
    }
}
