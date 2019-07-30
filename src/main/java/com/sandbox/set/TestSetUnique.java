package com.sandbox.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangxin on 2018/11/19.
 */
public class TestSetUnique {
    public static void main(String[] args) {
        List<OriginBrandItem> itemList = new ArrayList<>();
        OriginBrandItem item = new OriginBrandItem();
        item.setOriginBrandId(1);
        item.setOriginBrandName("1");

        OriginBrandItem item1 = new OriginBrandItem();
        item1.setOriginBrandId(1);
        item1.setOriginBrandName("1");

        OriginBrandItem item2 = new OriginBrandItem();
        item2.setOriginBrandId(2);
        item2.setOriginBrandName("2");

        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);

        for(OriginBrandItem brandItem: itemList) {
            System.out.println(brandItem);
        }

        System.out.println("---------------------------------");

        Set<OriginBrandItem> itemSet = new HashSet<>(itemList);
        for(OriginBrandItem setItem: itemSet) {
            System.out.println(setItem);
        }
    }
}
