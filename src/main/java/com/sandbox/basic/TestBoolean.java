package com.sandbox.basic;

/**
 * User: zhangxin
 * Date: 2016-10-15
 * Time: 11:11:00
 */
public class TestBoolean {
    public static void main(String[] args) {
        String str = "true";
        System.setProperty("str_key", str);
        Boolean flag = Boolean.getBoolean("str_key");
        if(flag) {
            System.out.println("str_key is true");
        } else {
            System.out.println("str_key is not true");
        }

        if(Boolean.parseBoolean("true")) {
            System.out.println("Boolean.parseBoolean(true) is true");
        }
    }
}
