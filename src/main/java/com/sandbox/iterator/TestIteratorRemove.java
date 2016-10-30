package com.sandbox.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2016-04-20
 * Time: 10:03:00
 */
public class TestIteratorRemove {

    public static void rm2ndNode(List<Integer> testList) {
        Iterator<Integer> iterator = testList.iterator();
        while(iterator.hasNext()) {
            Integer node = iterator.next();
            if(node == 2) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);

        System.out.println("size: " + testList.size());
        for(Integer item: testList) {
            System.out.println(item);
        }

        System.out.println("==========================");

        Iterator<Integer> iterator = testList.iterator();
        while(iterator.hasNext()) {
            Integer value = iterator.next();
            if(value == 4)
                iterator.remove();
        }

        iterator = testList.iterator();
        while(iterator.hasNext()) {
            Integer value = iterator.next();
            if(value == 2)
                iterator.remove();
        }

        System.out.println("size: " + testList.size());
        for(Integer item: testList) {
            System.out.println(item);
        }
    }
}
