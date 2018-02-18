package com.sandbox.jackson;

import com.alibaba.fastjson.JSON;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;

/**
 * Created by zhangxin on 15-4-3.
 */
public class MainTest {
    public static void main(String[] args) {

//        ObjectMapper objectMapper = new ObjectMapper();
//        Persion persion = new Persion("AAA", "A", 1);
//        System.out.println(persion);
//
//        try {
//            System.out.println(objectMapper.writeValueAsString(persion));
//
//            String jsonStr = "{\"name\":\"BBB\",\"sex\":\"B\",\"age\":2}";
//            persion = objectMapper.readValue(jsonStr, Persion.class);
//            System.out.println("Person.name=" + persion.getName());
//            System.out.println("Person.sex=" + persion.getSex());
//            System.out.println("Person.Age=" + persion.getAge());
//
//            System.out.println("=======================================");
//            Persion item1 = new Persion("CCC", "C", 2);
//            Persion item2 = new Persion("DDD", "D", 3);
//            Persion item3 = new Persion("EEE", "E", 4);
//            List<Persion> persionList = new ArrayList<Persion>();
//            persionList.add(item1);
//            persionList.add(item2);
//            persionList.add(item3);
//            System.out.println(objectMapper.writeValueAsString(persionList));
//
//            System.out.println("========================================");
//            Map<Integer, Persion> persionMap = new HashMap<Integer, Persion>();
//            persionMap.put(1, item1);
//            persionMap.put(2, item2);
//            persionMap.put(3, item3);
//            System.out.println(objectMapper.writeValueAsString(persionMap));
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            Persion persion = new Persion("aa", null, null);
//            System.out.println(objectMapper.writeValueAsString(persion));
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonStr = "{\"name\":\"BBB\",\"sex\":\"B\",\"age\":2,\"xx\":true}";
//            String jsonStr = "{\"name\":\"BBB\",\"sex\":\"B\"}";
//            Persion persion = objectMapper.readValue(jsonStr, Persion.class);
//            System.out.println("Person.name=" + persion.getName());
//            System.out.println("Person.sex=" + persion.getSex());
//            System.out.println("Person.Age=" + persion.getAge());


//            String jsonStr = "\"[{\"name\":\"BBB\",\"sex\":\"B\",\"age\":2,\"xx\":true}]\"";
//
//            jsonStr = jsonStr.substring(1, jsonStr.length() - 1);
//
//            List<Persion> persionList = JSON.parseArray(jsonStr, Persion.class);
//            for(Persion item: persionList) {
//                System.out.println(item);
//            }

            String aStr = new StringBuilder("A").append("/").append("B").append("/").append("C").toString().intern();
            String bStr = new StringBuilder("A").append("/").append("B").append("/").append("C").toString().intern();

            System.out.println(aStr);
            System.out.println(bStr);

            System.out.println("aStr == bStr: " + (aStr == bStr));

            System.out.println(System.identityHashCode(aStr));
            System.out.println(System.identityHashCode(bStr));


            String aaStr = new String("1").intern();
            String bbStr = new String("1").intern();

            System.out.println(System.identityHashCode(aaStr));
            System.out.println(System.identityHashCode(bbStr));

            String tableName = "ordersa#test_table";
            tableName = tableName.split("#")[1];
            System.out.print("tableName: " + tableName);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
