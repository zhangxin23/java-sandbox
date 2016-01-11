package com.sandbox.basic;

/**
 * Created by zhangxin on 16/1/11.
 */
public class TestScope {

    public static void main(String ... args) {

        {
            int a = 1;
            System.out.println(a);
        }

        int a = 2;
        System.out.println(a);
    }
}
