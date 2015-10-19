package com.test.java.chap09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: zhangxin
 * Date:   15-10-15
 */
public class ListInteger {

    public static void main(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();
        Integer first = new Integer(1);
        Integer second = new Integer(2);
        Integer first_1 = new Integer(1);

        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(first_1);

        for(Integer item: list) {
            if(map.get(item) == null) {
                List<String> strList = new ArrayList<>();
                map.put(item, strList);
            }
            map.get(item).add(item.toString());
        }

        for(Map.Entry<Integer, List<String>> item: map.entrySet()) {
            System.out.println(item.getKey() + ": ");
            for(String strItem: item.getValue())
                System.out.println("\t\t" + strItem);
        }
    }
}
