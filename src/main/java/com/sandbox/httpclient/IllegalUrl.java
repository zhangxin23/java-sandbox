package com.sandbox.httpclient;

/**
 * Author: zhangxin
 * Date:   15-11-18
 */
public class IllegalUrl {
    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        String content = HttpClientUtils.doGet(url);
        System.out.println(content);

        String txt = " 1 2 3 ";
        txt = txt.replaceAll("\\s+", "");
        System.out.println(txt);
    }
}
