package com.sandbox.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2016-05-04
 * Time: 21:01:00
 */
public class TestIteratorRemoveSecond {
    public static void main(String[] args) {
        List<Integer> value_list = new ArrayList<>();
        value_list.add(1);
        value_list.add(2);
        value_list.add(3);
        value_list.add(1);
        value_list.add(1);

        int index = 0;
        int find_index = 0;
        for(Integer item: value_list) {
            if(item == 1) {
                find_index = index;
            }
            index++;
        }

//        System.out.println(value_list.get(find_index));

//        List<Integer> sub_list = value_list.subList(find_index + 1, value_list.size());
//
//        value_list.removeAll(sub_list);
//
//        for(Integer item: value_list) {
//            System.out.println(item);
//        }

        Iterator<Integer> iterator = value_list.listIterator(find_index + 1);
        while(iterator.hasNext()) {
            Integer item = iterator.next();
            System.out.println("iterator.next() = " + item);
            iterator.remove();
        }

        for(Integer item: value_list) {
            System.out.println(item);
        }
    }
}
