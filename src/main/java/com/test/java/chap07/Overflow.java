package com.test.java.chap07;

/**
 * Author: zhangxin
 * Date:   15-9-22
 */
public class Overflow {

    public static boolean testOverflow(int x, int y) {
        if(x > 0 && y > 0 && x > Integer.MAX_VALUE - y)
            throw new IllegalArgumentException("overflow");
        if(x < 0 && y < 0 && x < Integer.MIN_VALUE - y)
            throw new IllegalArgumentException("overflow");

        return true;
    }

    public static void main(String[] args) {
        testOverflow(Integer.MAX_VALUE, 1);
    }
}
