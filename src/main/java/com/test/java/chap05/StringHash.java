package com.test.java.chap05;

/**
 * Author: zhangxin
 * Date:   15-8-25
 */
public class StringHash {
    public static int strHash(String value) {
        int hash = 0;
        for(int i = 0; i < value.length(); i++) {
            hash = 31 * hash + value.charAt(i);
        }
        return hash & 0x7FFFFFFF;
    }

    public static void main(String[] args) {
        System.out.println("hash(123) = " + strHash("123"));

        long al = 0x2FFFFFFF1L;
        System.out.println("al = " + al);
        int ai = (int)al;
        System.out.println("ai = " + ai);
        int aii = 0xFFFFFFF1;
        System.out.println("aii = " + aii);

        int aii7F = aii & 0x7FFFFFFF;
        System.out.println("aii7F = " + aii7F);

        int aii7F_1 = -15 & 0x7FFFFFFF;
        System.out.println("aii7F_1 = " + aii7F_1);

        long aiil = (long)aii;
        System.out.println("aiil = " + aiil);

        int mod = -32 % 15;
        System.out.println("mod = " + mod);
    }
}
