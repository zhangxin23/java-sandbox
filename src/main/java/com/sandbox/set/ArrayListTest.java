package com.sandbox.set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Author: zhangxin
 * Date:   16-2-16
 */
public class ArrayListTest {

    public static void main(String ... args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1, 3);

        for(Integer item: list) {
            System.out.println(item);
        }


        System.out.println("----------------------------");
        list.clear();

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("===========================");

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.addElement(3);
        vector.add(0, 5);
        for(Integer item: vector) {
            System.out.println(item);
        }

        System.out.println("---------------------------");
        vector.set(0, 6);
        for(int i = 0; i < vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }

        System.out.println("===========================");

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        for(Integer item: linkedList) {
            System.out.println(item);
        }

        System.out.println("-------------------------");
        linkedList.set(1, 5);
        for(int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }


        System.out.println("====================================");

        List<Integer> testInsertList = new ArrayList<>();
        testInsertList.add(1);
        testInsertList.add(2);
        testInsertList.add(3);
        testInsertList.add(3, 11);

        for(Integer item: testInsertList) {
            System.out.println(item);
        }
    }
}
