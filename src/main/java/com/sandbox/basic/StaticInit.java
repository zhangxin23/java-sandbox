package com.sandbox.basic;

/**
 * Author: zhangxin
 * Date:   15-11-30
 */
public class StaticInit {
    static {
        System.out.println("static block init.");
    }

    public StaticInit() {
        System.out.println("constructor init");
    }

    public void showMag() {
        System.out.println("instance call showMsg.");
    }

    public static void main(String[] args) {
        System.out.println("main func init");
        StaticInit test = new StaticInit();
        test.showMag();
    }
}
