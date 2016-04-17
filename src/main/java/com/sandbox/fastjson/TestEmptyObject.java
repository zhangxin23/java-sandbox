package com.sandbox.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * User: zhangxin
 * Date: 2016-04-11
 * Time: 10:51:00
 */
public class TestEmptyObject {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.toJSONString());
    }
}
