package com.test.java.chap01;

import java.util.*;

/**
 * Created by zhangxin on 15-5-20.
 */
public class Third {
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

    public static void main(String[] args) {
        String str1 = new String("A");
        String str2 = new String("A");
        String str3 = new String("A");
        String str4 = "B";
        String str5 = "B";
        String str6 = "B";

        List<String> strList = new ArrayList<String>();
        strList.add(str1);
        strList.add(str2);
        strList.add(str3);
        strList.add(str4);
        strList.add(str5);
        strList.add(str6);

        List<String> rmDupStrList = removeDupString(strList);
        for(String item: rmDupStrList)
            System.out.println(item);

        if(str1 == str2)
            System.out.println("str1 == str2");

        if(str1.equals(str2))
            System.out.println("str1.equals(str2)");

        if(str5 == str6)
            System.out.println("str5 == str6");

        if(str5.equals(str6))
            System.out.println("str5.equals(str6)");

        System.out.println("---------------------");

        Set<String> s = new HashSet<String>(strList);
        System.out.println("Set.size() = " + s.size());
        for(String item: s)
            System.out.println("Set: " + item);

        System.out.println("**********************");
        List<Long> aList = new ArrayList<Long>();
        List<Long> bList = new ArrayList<Long>();
//        aList.add(new Long(1));
        aList.add(new Long(2));
//        aList.add(new Long(3));
        System.out.println("============================");
        for(Long item: aList)
            System.out.println(item);

        bList.add(new Long(2));
        bList.add(new Long(3));
        bList.add(new Long(4));
        aList.retainAll(bList);
        System.out.println("============================");
        for(Long item: aList)
            System.out.println(item);

        System.out.println("============================");
        for(Long item: bList)
            System.out.println(item);


        System.out.println("+++++++++++++++++++++++++");
        String aStr = "Hello";
        String bStr = "Hello";
        if(aStr == bStr)
            System.out.println("aStr == bStr");

        String cStr = new String("Hello");
        if(aStr == cStr)
            System.out.println("aStr == cStr");
        else
            System.out.println("aStr != cStr");

        if(aStr.equals(cStr))
            System.out.println("aStr.equals(cStr)");
    }
}
