package com.sandbox.java8.chapter2;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/21 10:16
 */
public class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
