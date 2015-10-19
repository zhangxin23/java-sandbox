package com.test.java.chap06;

/**
 * Author: zhangxin
 * Date:   15-9-6
 */
public class Main {
    public static void main(String[] args) {
        InterfaceA aimpl = new InterfaceAImpl();
        aimpl.showInterfaceA();

        System.out.println("------------------------------------");

        InterfaceA abimpl = new InterfaceABImpl();
        abimpl.showInterfaceA();

        System.out.println("------------------------------------");

        InterfaceB abimpl_1 = new InterfaceABImpl();
        abimpl_1.showInterfaceB();

        System.out.println("------------------------------------");

        InterfaceAB abimpl_2 = new InterfaceABImpl();
        abimpl_2.showInterfaceA();
        abimpl_2.showInterfaceB();
        abimpl_2.showInterfaceAB();
    }
}
