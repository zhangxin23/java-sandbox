package com.sandbox.function.exercise;

/**
 * Author: zhangxin
 * Date:   15-12-18
 */
@FunctionalInterface
public interface FInterface<T> {
    T get();

    default String desc() {
        return "Functional Interface, like Consumer.";
    }
}
