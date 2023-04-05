package com.sandbox.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2017-01-03
 * Time: 15:29:00
 */
public class ListSortComparator {
    public static void main(String... args) {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(2.1);
        doubleList.add(1.1);
        doubleList.add(5.1);
        doubleList.add(3.1);

        Collections.sort(doubleList, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(Double.compare(o1, o2) < 0)
                    return 1;
                else if(Double.compare(o1, o2) > 0)
                    return -1;
                else
                    return 0;
            }
        });

        for(Double item: doubleList) {
            System.out.println(item);
        }

        System.out.println("=======================");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);

        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(Integer item: integerList) {
            System.out.println(item);
        }
    }
}
