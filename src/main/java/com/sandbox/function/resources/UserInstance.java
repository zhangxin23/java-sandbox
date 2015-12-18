package com.sandbox.function.resources;

/**
 * Author: zhangxin
 * Date:   15-12-17
 */
@FunctionalInterface
public interface UserInstance<T, X extends Throwable> {
    void accept(T t) throws X;
}
