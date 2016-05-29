package com.sandbox.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * User: zhangxin
 * Date: 2016-04-28
 * Time: 18:24:00
 */
public class TestJsonObject {
    public static void main(String[] args) {
        Object obj = new JSONObject();


        if(obj instanceof  JSONObject) {
            System.out.println("JSON Object");
        } else {
            System.out.println("Object");
        }

        obj = "{}";

        if(obj instanceof String) {
            System.out.println("String");
        } else {
            System.out.println("Object");
        }
    }
}
