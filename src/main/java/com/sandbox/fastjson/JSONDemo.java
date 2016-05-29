package com.sandbox.fastjson;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;


public class JSONDemo {

    public static String toJSONString(Object object,
                                      SerializerFeature ...features) {
        SerializeWriter out = new SerializeWriter();
        String s;
        JSONSerializer serializer = new JSONSerializer(out);
        SerializerFeature arr$[] = features;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            SerializerFeature feature = arr$[i$];
            serializer.config(feature, true);
        }

        serializer.getValueFilters().add(new ValueFilter() {
            public Object process(Object obj, String s, Object value) {
                if(null!=value) {
//                    if(value instanceof java.util.Date) {
//                        return String.format("%1$tF %1tT", value);
//                    }
                    return value;
                }else {
                    return "{}";
                }
            }
        });
        serializer.write(object);
        s = out.toString();
        out.close();
        return s;
    }

    public static void main(String[] args) {
//        List list = new ArrayList();
//        for (int i = 0; i <= 2; i++) {
//            Map m = new HashMap();
//            m.put(String.valueOf(i), null);
//            m.put("date", new Date(System.currentTimeMillis()));
//            list.add(m);
//        }
//
//        String json = JSONDemo.toJSONString(list);
//
//        System.err.println(json);
//
//        List<Map> parse = (List<Map>) JSON.parse(json);
//
//        System.err.println("end ....");

        TestNullField.Item item = new TestNullField.Item();
        String json = JSONDemo.toJSONString(item);
        System.out.println(json);
    }
}
