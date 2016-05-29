package com.sandbox.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhangxin
 * Date: 2016-05-10
 * Time: 14:45:00
 */
public class FastJsonNullFieldDefault {
    private static final ValueFilter VALUE_FILTER = new ValueFilter() {
        private Map<String, Object> typeDefaultValueMap = new HashMap<String, Object>(){
            {
                put("java.lang.Integer", 0);
                put("java.lang.Long", 0);
                put("java.lang.Short", 0);
                put("java.lang.Byte", 0);
                put("java.lang.Boolean", false);
                put("java.lang.Char", 0);
                put("java.lang.String", "");
                put("java.lang.Double", 0.0);
                put("java.lang.Float", 0.0);
                put("java.util.List", new ArrayList());
                put("[I", new ArrayList());
            }
        };

        @Override
        public Object process(Object object, String name, Object value) {
            if(value == null) {
                try {
                    Field field = object.getClass().getDeclaredField(name);
                    String declareType = field.getType().getName();
                    if(typeDefaultValueMap.get(declareType) == null) {
                        return new JSONObject();
                    } else {
                        return typeDefaultValueMap.get(declareType);
                    }
                } catch (NoSuchFieldException e) {

                } catch (Exception e) {

                }
            }
            return value;
        }
    };

    /**
     * 带ValueFilter的contructResponse
     * */
    public static JSONObject constructResponseWithValueFilter(int code, String msg, Object data) {
        JSONObject jo = new JSONObject();
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("data", JSON.toJSONString(data, VALUE_FILTER));
        return jo;
    }

    public static void main(String[] args) {
        TestNullField.Item item = new TestNullField.Item();
        JSONObject object = constructResponseWithValueFilter(1, "Success", item);
        System.out.println(object);

        System.out.println("=========================================================================");

        List<TestNullField.Item> list = new ArrayList<>();
        list.add(new TestNullField.Item());
        list.add(new TestNullField.Item());
        list.add(new TestNullField.Item());
        list.add(new TestNullField.Item());
        list.add(new TestNullField.Item());
        list.add(new TestNullField.Item());
        JSONObject obj = constructResponseWithValueFilter(1, "Success", list);
        System.out.println(obj);
    }
}
