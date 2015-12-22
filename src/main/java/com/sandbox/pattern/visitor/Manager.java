package com.sandbox.pattern.visitor;

/**
 * Author: zhangxin
 * Date:   15-12-22
 */
public class Manager implements Visitor {

    @Override
    public void apply(Park park) {
        System.out.println("Manager visit " + park.getName());
    }
}
