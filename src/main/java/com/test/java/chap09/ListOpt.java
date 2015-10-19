package com.test.java.chap09;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-10-15
 */
public class ListOpt {
    public static void main(String[] args) {
        Integer first_1 = new Integer(1);
        Integer first_2 = new Integer(2);
        Integer first_3 = new Integer(3);
        Integer first_4 = new Integer(4);
        Integer first_5 = new Integer(5);

        Integer second_1 = new Integer(4);
        Integer second_2 = new Integer(5);
        Integer second_3 = new Integer(6);
        Integer second_4 = new Integer(7);
        Integer second_5 = new Integer(8);

        List<Integer> firstList = new ArrayList<>();
        firstList.add(first_1);
        firstList.add(first_2);
        firstList.add(first_3);
        firstList.add(first_4);
        firstList.add(first_5);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(second_1);
        secondList.add(second_2);
        secondList.add(second_3);
        secondList.add(second_4);
        secondList.add(second_5);

        //xor
        List<Integer> allList = new ArrayList<>();
        allList.addAll(firstList);
        allList.addAll(secondList);
        firstList.retainAll(secondList);
        allList.removeAll(firstList);
        for(Integer item: allList)
            System.out.println(item);
    }
}
