package com.sandbox.proxy.JdkProxy;

/**
 * Author: zhangxin
 * Date:   16-1-4
 */
public class RealSubject implements Subject {

    public RealSubject() {
    }

    @Override
    public void request() {
        System.out.println("from RealSubject class ... ");
    }
}
