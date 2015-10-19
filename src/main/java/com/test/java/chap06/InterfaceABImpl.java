package com.test.java.chap06;

/**
 * Author: zhangxin
 * Date:   15-9-6
 */
public class InterfaceABImpl implements InterfaceAB {

    @Override
    public void showInterfaceAB() {
        System.out.println("InterfaceABImpl: showInterfaceAB");
    }

    @Override
    public void showInterfaceB() {
        System.out.println("InterfaceABImpl: showInterfaceB");
    }

    @Override
    public void showInterfaceA() {
        System.out.println("InterfaceABImpl: showInterfaceA");
    }
}
