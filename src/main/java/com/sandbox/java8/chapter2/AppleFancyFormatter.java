package com.sandbox.java8.chapter2;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/21 10:16
 */
public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
