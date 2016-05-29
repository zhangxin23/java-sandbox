package com.sandbox.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.BooleanArraySerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhangxin
 * Date: 2016-05-10
 * Time: 10:14:00
 */
public class TestNullField {

    private static String[] types = {"java.lang.Integer",
            "java.lang.Double",
            "java.lang.Float",
            "java.lang.Long",
            "java.lang.Short",
            "java.lang.Byte",
            "java.lang.Boolean",
            "java.lang.Char",
            "java.lang.String",
            "java.util.Date",
            "int","double","long","short","byte","boolean","char","float"};

    private static String first2Up(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

    private static ValueFilter nullValueFilter = new ValueFilter(){
        @Override
        public Object process(Object object, String name, Object value) {
            if(value==null){
                try {
                    Method method = object.getClass().getDeclaredMethod("get" + first2Up(name));

                    try {
                        Field field = object.getClass().getDeclaredField(name);
                        Class type = field.getType();
                        System.out.println(type);
                    } catch(Exception e) {
                        System.out.println("Nu Such Field.");
                    }

                    for(String type : types){
                        if(method.getReturnType().getName().equals(type)){
                            return "";
                        }
                    }

                    if (method.getReturnType().isAssignableFrom(List.class) &&
                            !method.getReturnType().getName().equals("java.lang.Object")) {
                        return new int[0];
                    }

                    return new Object();

                } catch (SecurityException | NoSuchMethodException e) {
                    e.printStackTrace();
                    return value;
                }
            }
            return value;
        }

    };



    private static ValueFilter valueFilterField = new ValueFilter() {
        @Override
        public Object process(Object source, String name, Object value) {
            if(value == null) {
                try {
                    Field field = source.getClass().getDeclaredField(name);
                    Class fieldType = field.getType();
                    if(fieldType.getName().equals("java.lang.Integer"))
                        return 0;
                    else if(fieldType.getName().equals("java.lang.String"))
                        return "";
                    else if(fieldType.getName().equals("[I"))
                        return new ArrayList();
                    else if(fieldType.getName().equals("java.util.List"))
                        return new ArrayList();
                    else
                        return new JSONObject();
                } catch (Exception ex) {

                }
            }
            return value;
        }
    };

    public static void main(String[] args) {
        Map< String , Object > jsonMap = new HashMap< String , Object>();
        jsonMap.put("a",1);
        jsonMap.put("b","");
        jsonMap.put("c",null);
        jsonMap.put("d","wuzhuti.cn");

        String str = JSONObject.toJSONString(jsonMap);
        System.out.println(str);

        System.out.println("======================================");


//        ValueFilter valueFilter = new ValueFilter() {
//            @Override
//            public Object process(Object source, String name, Object value) {
//                if(value != null)
//                    return value;
//                else
//                    return "{}";
//            }
//        };

        Item item = new Item();
        System.out.println(JSON.toJSONString(item, valueFilterField, SerializerFeature.WriteMapNullValue));
//        JSONObject jo = new JSONObject();
//        jo.put("code", 1);
//        jo.put("msg", "Success");
////        jo.put("data", JSON.toJSON(item));
////        jo.put("data", JSON.toJSONString(item, SerializerFeature.WriteMapNullValue));
//        jo.put("data", JSON.toJSONString(item, valueFilterField));
//        System.out.println(jo);
    }

    public static class Item {
        private int type;
        private String name;
        private SubItem sub_item;
        private Integer haha;
        private List<Integer> list;
        private int[] array = null;

        public Integer getHaha() {
            return haha;
        }

        public void setHaha(Integer haha) {
            this.haha = haha;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public SubItem getSub_item() {
            return sub_item;
        }

        public void setSub_item(SubItem sub_item) {
            this.sub_item = sub_item;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int[] getArray() {
            return array;
        }

        public void setArray(int[] array) {
            this.array = array;
        }
    }

    public static class SubItem {
        private int sub_type;
        private String sub_name = "";

        public int getSub_type() {
            return sub_type;
        }

        public void setSub_type(int sub_type) {
            this.sub_type = sub_type;
        }

        public String getSub_name() {
            return sub_name;
        }

        public void setSub_name(String sub_name) {
            this.sub_name = sub_name;
        }
    }
}
