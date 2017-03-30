package com.sandbox.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zhangxin on 17/3/5.
 */
public class ListIteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        ListIterator<Integer> listIterator = list.listIterator(3);
        while(listIterator.hasNext()) {
            Integer item = listIterator.next();
            if(item == 5) {
                listIterator.remove();
            }
        }
    }
}
