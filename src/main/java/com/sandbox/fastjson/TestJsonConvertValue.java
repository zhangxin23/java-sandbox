package com.sandbox.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * User: zhangxin
 * Date: 2016-05-29
 * Time: 08:06:00
 */

/**
 * 验证 某字段为整型,但是待解析的字符串中,该字段为String,也可以正常解析这个字段.
 * */
public class TestJsonConvertValue {
    public static void main(String[] args) {
        String json = "{\"id\":\"123\", \"name\":\"abc\"}";
        JsonRecord record = JSONObject.parseObject(json, JsonRecord.class);
        System.out.println("id: " + record.getId());
        System.out.println("name: " + record.getName());
    }
}
