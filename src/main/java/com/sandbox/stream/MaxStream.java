package com.sandbox.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-11-11
 */

class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer s1, Integer s2) {
        return s1.compareTo(s2);
    }
}

public class MaxStream {
    public static void main(String[] args) {
        List<Integer> srcList = Arrays.asList(1, 2, 3, 4, 5, 9, 8, 7);
//        srcList.stream().max(new IntegerComparator()).ifPresent(item->System.out.println(item));
        srcList.stream().max((x, y)->x.compareTo(y)).ifPresent(s->System.out.println(s));
    }
}
