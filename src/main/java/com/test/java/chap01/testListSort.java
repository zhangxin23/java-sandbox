package com.test.java.chap01;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by zhangxin on 15-5-11.
 */

class Item {
    private String name;
    private Integer height;

    public Item(String name, Integer height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Item))
            return false;

        return this.height.compareTo(((Item) obj).getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * height;
    }
}

public class testListSort {

    public static List<Long> removeDupLong(List<Long> idList) {
        if(idList == null)
            return null;

        List<Long> tmpList = new ArrayList<Long>();
        Iterator<Long> iterator = idList.iterator();
        while(iterator.hasNext()) {
            Long tmp = iterator.next();
            if(tmpList.contains(tmp))
                iterator.remove();
            else
                tmpList.add(tmp);
        }
        return tmpList;
    }

    public static List<String> removeDupString(List<String> strList) {
        if(strList == null)
            return null;

        List<String> tmpList = new ArrayList<String>();
        Iterator<String> iterator = strList.iterator();
        while(iterator.hasNext()) {
            String tmp = iterator.next();
            if(tmpList.contains(tmp))
                iterator.remove();
            else
                tmpList.add(tmp);
        }
        return tmpList;
    }

    public static List<Item> removeDupItem(List<Item> strList) {
        if(strList == null)
            return null;

        List<Item> tmpList = new ArrayList<Item>();
        Iterator<Item> iterator = strList.iterator();
        while(iterator.hasNext()) {
            Item tmp = iterator.next();
            if(tmpList.contains(tmp))
                iterator.remove();
            else
                tmpList.add(tmp);
        }
        return tmpList;
    }

    public static void main(String[] args) {
        Item one = new Item("a", 15);
        Item two = new Item("b", 10);
        Item three = new Item("c", 11);

        List<Item> itemList = new ArrayList<Item>();
        itemList.add(one);
        itemList.add(two);
        itemList.add(three);

        for(Item item: itemList)
            System.out.println(item.getName() + ": " + item.getHeight());

        Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getHeight().compareTo(o2.getHeight());
            }
        });


        System.out.println("----------------------------------");
        for(Item item: itemList)
            System.out.println(item.getName() + ": " + item.getHeight());




        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        List<Long> longList = new ArrayList<Long>();
        longList.add(1L);
        longList.add(2L);
        longList.add(1L);

        List<Long> tmpList = removeDupLong(longList);
        for(Long item: tmpList)
            System.out.println(item);



        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("B");
        strList.add("A");
        List<String> strTmpList = removeDupString(strList);
        for(String item: strTmpList)
            System.out.println(item);


        System.out.println("**************************************");
        Long firstLong = new Long(1L);
        Long secondLong = new Long(1L);
        if(firstLong.equals(secondLong))
            System.out.println("firstLong == secondLong");

        System.out.println("***************************************");
        Integer firstInteger = new Integer(1);
        Integer secondInteger = new Integer(1);
        if(firstInteger.equals(secondInteger))
            System.out.println("firstInteger == secondInteger");


        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        List<Item> itemList1 = new ArrayList<Item>();
        itemList1.add(new Item("a", 1));
        itemList1.add(new Item("a", 1));
        itemList1.add(new Item("a", 1));

        List<Item> retList = removeDupItem(itemList1);

        for(Item item: retList)
            System.out.println(item.getName() + ": " + item.getHeight());


        System.out.println("=======================================");
        Date date = new Date(1433741890323L);
        System.out.println(date.toString());
        date = new Date(1432187992786L);
        System.out.println(date.toString());
        date = new Date(1431945183068L);
        System.out.println(date.toString());
        date = new Date(1431568871351L);
        System.out.println(date.toString());


        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(System.currentTimeMillis() + 600 * 1000);

        System.out.println("===================================");
        System.out.println(Charset.defaultCharset());

        System.out.println("------------------------------------");
        int[] codepoints = { 0x1F601 }; // U+1F601
        String s1 = new String(codepoints, 0, codepoints.length);
        System.out.println(s1);
        byte[] bytes = s1.getBytes(StandardCharsets.UTF_8); // As UTF-8 (Unicode) bytes
        System.out.println(Arrays.toString(bytes));

        System.out.println("--------------------------------------");
        String s = new StringBuilder()
                .append("Thats a nice joke ")
                .appendCodePoint(0x1F606)
                .appendCodePoint(0x1F606)
                .appendCodePoint(0x1F606)
                .append(" ")
                .appendCodePoint(0x1F61B)
                .toString();
        char[] chars = s.toCharArray();
        int index;
        char ch1;
        char ch2;

        index = 0;
        while (index < chars.length - 1) { // -1 because we're looking for two-char-long things
            ch1 = chars[index];
            if ((int)ch1 == 0xD83C) {
                ch2 = chars[index+1];
                if ((int)ch2 >= 0xDF00 && (int)ch2 <= 0xDFFF) {
                    System.out.println("Found emoji at index " + index);
                    index += 2;
                    continue;
                }
            }
            else if ((int)ch1 == 0xD83D) {
                ch2 = chars[index+1];
                if ((int)ch2 >= 0xDC00 && (int)ch2 <= 0xDDFF) {
                    System.out.println("Found emoji at index " + index);
                    index += 2;
                    continue;
                }
            }
            ++index;
        }

        System.out.println("----------------------------------------");
        System.out.println("hahaha\uD83D\uDE1Chahaha");
    }
}
