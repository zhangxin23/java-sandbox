package com.sandbox.java8.chapter9;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/27 15:32
 */
public interface InterfaceA {
    default void hello() {
        System.out.println("Hello from A");
    }
}
