package com.sandbox.proxy.pattern;

/**
 * Author: zhangxin
 * Date:   16-1-4
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("from RealSubject class ... ");
    }
}
