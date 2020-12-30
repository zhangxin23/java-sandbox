package com.sandbox.java8.chapter9;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/27 15:10
 */
public abstract class AbstractClassMethod {
    private int status = 0;

    abstract void abstractMethod();

    public void defaultMethod(String value) {
        System.out.println("default value: " + value);
    }
}
