package com.sandbox.pattern.visitor;

/**
 * Author: zhangxin
 * Date:   15-12-22
 */
public class Client {

    public static void main(String ... args) {
        Park park = new ParkImplA();
        Visitor visitor = new Guest();

        visitor.apply(park);

        park = new ParkImplB();
        visitor = new Manager();
        visitor.apply(park);
    }
}
