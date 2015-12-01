package com.sandbox.basic;

/**
 * Author: zhangxin
 * Date:   15-11-30
 */
public class StaticBlock {
    static {
        x = 10;
    }

    private static int x = 20;

    public static void main(String[] args) {
        System.out.println(x);
    }
}
