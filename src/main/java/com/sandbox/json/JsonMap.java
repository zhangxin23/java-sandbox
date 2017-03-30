package com.sandbox.json;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * User: zhangxin
 * Date: 2016-03-09 13:03:00
 */
public class JsonMap {
    public static void map2Json(){
        Map map = new HashMap();
        Address address1 = new Address("广东省","深圳市","科苑南路","580053");
        map.put("address1", address1);
        Address address2 = new Address("江西省","南昌市","阳明路","330004");
        map.put("address2", address2);
        Address address3 = new Address("陕西省","西安市","长安南路","710114");
        map.put("address3", address3);
        String jsonText = JSON.toJSONString(map, true);
        System.out.println("map2Json(true)方法：jsonText==" + jsonText);

        System.out.println("--------------------------------------");
        System.out.println("map2Json() method: jsonText = " + JSON.toJSONString(map));
    }

    public static void main(String ... args) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, Arrays.asList("123", "456"));
        map.put(2, Arrays.asList("123", "456"));
        System.out.println("json string = " + JSON.toJSONString(map));

        Map<Integer, List<String>> convertedMap = (Map<Integer, List<String>>)JSON.parse(JSON.toJSONString(map));
        for(Map.Entry<Integer, List<String>> entry: convertedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
//            System.out.print(entry.getKey());
//            for(String item: entry.getValue()) {
//
//            }
        }

        System.out.println("---------------------------");
        Map<String, Object> mapList = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        mapList.put("first", list1);
        mapList.put("second", list1);
        System.out.println("json list string = " + JSON.toJSONString(mapList));
    }
}
