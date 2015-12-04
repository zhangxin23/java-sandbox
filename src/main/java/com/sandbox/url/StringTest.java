package com.sandbox.url;

/**
 * Author: zhangxin
 * Date:   15-12-3
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "http:\\/\\/abc.com";
        System.out.println(str.replaceAll("\\\\", ""));
    }
}
