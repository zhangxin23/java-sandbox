package com.sandbox.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * User: zhangxin
 * Date: 2016-07-05
 * Time: 09:42:00
 */
public class TestJsonDeseria {
    public static class Item {
        @JSONField(name = "logId")
        private long wm_log_id;
        private String version = "";

        public long getWm_log_id() {
            return wm_log_id;
        }

        public void setWm_log_id(long wm_log_id) {
            this.wm_log_id = wm_log_id;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static void main(String[] args) {
        String json = "{\"logId\":123456, \"version\":\"version_abc\"}";
        Item item = JSONObject.parseObject(json, Item.class);
        System.out.println("wm_log_id: " + item.getWm_log_id());
        System.out.println("version: " + item.getVersion());
    }
}
