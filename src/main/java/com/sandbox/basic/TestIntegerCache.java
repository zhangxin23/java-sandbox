package com.sandbox.basic;

/**
 * User: zhangxin
 * Date: 2017-01-11
 * Time: 10:29:00
 */
public class TestIntegerCache {

    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b); //false

        Integer aa = new Integer(666);
        Integer bb = new Integer(666);
        System.out.println(aa == bb); //false

        Integer aValueof = Integer.valueOf(66);
        Integer bValueof = Integer.valueOf(66);
        System.out.println(aValueof == bValueof); //true

        Integer aaValueof = Integer.valueOf(666);
        Integer bbValueof = Integer.valueOf(666);
        System.out.println(aaValueof == bbValueof); //false
    }
}
