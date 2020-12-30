package com.sandbox.java8.chapter9;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/27 16:41
 */
public class ClassC implements InterfaceA, InterfaceB{
    public void hello() {
        InterfaceB.super.hello();
    }

    public static void main(String[] args) {
        new ClassC().hello();
    }
}
