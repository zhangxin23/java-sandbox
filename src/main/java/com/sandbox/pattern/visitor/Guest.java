package com.sandbox.pattern.visitor;

/**
 * Author: zhangxin
 * Date:   15-12-22
 */
public class Guest implements Visitor {

    @Override
    public void apply(Park park) {
        System.out.println("Guest visit " + park.getName());
    }
}
