package com.sandbox.encrypt.urlencoder;

import java.net.URLEncoder;

/**
 * User: zhangxin
 * Date: 2016-03-09 09:36:00
 */
public class TestUrlEncoder {

    public static void main(String ... args) {
        try{
            String str = URLEncoder.encode("", "UTF-8");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
