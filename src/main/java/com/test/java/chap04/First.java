package com.test.java.chap04;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Author: zhangxin
 * Date:   15-7-27
 */
public class First {

    public static void setArgument(String arg) {
        arg = "set argument.";
    }

    public static void main(String [] args) {
        String str = "123";
        byte[] base64Bytes = Base64.encodeBase64(str.getBytes());
        String rtn = new String(base64Bytes);
        System.out.println(rtn);

        System.out.println("--------------------------------");
        String value = "hello";
        setArgument(value);
        System.out.println(value);


        System.out.println("=================================================");
        String[] strSplits = "1|2".split("\\|");
        for(String item: strSplits) {
            System.out.println(item);
        }
    }
}
