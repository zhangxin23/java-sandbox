package com.sandbox.set;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Author: zhangxin
 * Date:   15-11-26
 */
public class HashMapTable {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        HashMap<String, Integer> map = new HashMap<>();

        table.put("a", 1);
        table.put("b", 2);
//        table.put(null, 0);
//        table.put("0", null);

        map.put("aa", 11);
        map.put("bb", 22);
        map.put(null, 0);
        map.put("0", null);

        for(Map.Entry<String, Integer> item: table.entrySet()) {
            System.out.println(item.getKey() + "-->" + item.getValue());
        }

        System.out.println("--------------------------");

        for(Map.Entry<String, Integer> item: map.entrySet()) {
            System.out.println(item.getKey() + "-->" + item.getValue());
        }

        System.out.println("--------------------------");
        System.out.println("table size: " + table.size());
        System.out.println("map size: " + table.size());
    }
}
