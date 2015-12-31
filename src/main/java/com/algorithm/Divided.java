package com.algorithm;

/**
 * Author: zhangxin
 * Date:   15-12-28
 */
public class Divided {

    public static void main(String ... args) {
        int a = 100;
        int b = 2;
        int count = 0;
        while(a > 0) {
            a -= b;
            count++;
        }

        System.out.println("a/b = " + count);
    }
}
