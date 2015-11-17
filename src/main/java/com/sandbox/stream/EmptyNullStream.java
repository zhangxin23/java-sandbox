package com.sandbox.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-11-12
 */
public class EmptyNullStream {
    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.stream().forEach(x->System.out.println(x));
    }
}
