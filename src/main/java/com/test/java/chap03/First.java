package com.test.java.chap03;

import java.util.*;

/**
 * Created by zhangxin on 15-6-1.
 */
public class First {
    public static void main(String[] args) {
        List<Integer> leftList = new ArrayList<Integer>();
        leftList.add(11);
        leftList.add(2);
        leftList.add(21);
        leftList.add(13);

        Collections.sort(leftList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(Integer item: leftList) {
            System.out.println(item);
        }

        System.out.println("--------------------------------");

        List<Integer> rightList = new ArrayList<Integer>();
        rightList.add(2);
        rightList.add(3);
//        rightList.add(3);
        rightList.add(4);

        leftList.retainAll(rightList);
        Iterator ite = leftList.iterator();
        while(ite.hasNext())
            System.out.println(ite.next());



        System.out.println("---------------------------------");
        long dayMs = 24 * 3600 * 1000;
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - 24 * dayMs);
        System.out.println(System.currentTimeMillis() - 24 * 24 * 3600 * 1000);
        System.out.println(System.currentTimeMillis() - 25 * dayMs);
        System.out.println(System.currentTimeMillis() - 25 * 24 * 3600 * 1000);

        System.out.println(25 * 24 * 3600 * 1000l);
    }
}
