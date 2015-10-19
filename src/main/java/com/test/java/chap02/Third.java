package com.test.java.chap02;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by zhangxin on 15-5-29.
 */
public class Third {
    public static void main(String[] args) {
        System.out.println("ArrayList test:");
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(12);
        arrayList.add(2);
        arrayList.add(5);
        for(Integer item: arrayList)
            System.out.println("\t" + item);
        System.out.println("\t----------------");
        arrayList.remove(1);
        for(Integer item: arrayList)
            System.out.println("\t" + item);

        System.out.println("\nLinkedList test:");
        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(22);
        linkedList.add(3);
        linkedList.add(100);
        Iterator ite = linkedList.iterator();
        while(ite.hasNext()) {
            System.out.println("\t" + ite.next());
        }
        System.out.println("\t---------------");
        linkedList.remove(0);
        ite = linkedList.iterator();
        while(ite.hasNext()) {
            System.out.println("\t" + ite.next());
        }

        System.out.println("\nHashSet test:");
        Set<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(100);
        hashSet.add(100);
        hashSet.add(21);
        Iterator iteSet = hashSet.iterator();
//        while(iteSet.hasNext()) {
//            System.out.println("\t" + iteSet);
//        }
        for(Integer item: hashSet) {
            System.out.println("\t" + item);
        }
        System.out.println("\t--------------------");
        hashSet.remove(100);
        for(Integer item: hashSet)
            System.out.println("\t" + item);

        System.out.println("\nTreeSet test:");
        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(10);
        for(Integer item: treeSet)
            System.out.println("\t" + item);
        System.out.println("\t---------------------");
        treeSet.remove(10);
        for(Integer item: treeSet)
            System.out.println("\t" + item);

        System.out.println("\nHashMap test:");
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("A", 1);
        hashMap.put("A", 2);
        hashMap.put("B", 3);
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for(Map.Entry<String, Integer> item: entrySet) {
            System.out.println("\t" + item.getKey() + "---" + item.getValue());
        }
        System.out.println("\t-----------------");
        hashMap.remove("A");
        for(Map.Entry<String, Integer> item: entrySet) {
            System.out.println("\t" + item.getKey() + "---" + item.getValue());
        }

        System.out.println("\nTreeMap test:");
        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("A", 11);
        treeMap.put("B", 22);
        treeMap.put("A", 33);
        Set<String> keySet = treeMap.keySet();
        for(String item: keySet) {
            System.out.println("\t" + item + "---" + treeMap.get(item));
        }
        System.out.println("\t----------------");
        treeMap.remove("A");
        Set<String> keySet1 = treeMap.keySet();
        for(String item: keySet1) {
            System.out.println("\t" + item + "---" + treeMap.get(item));
        }


        System.out.println("=======================================");
        byte[] b3 = {-16,-97,-113,-128};
        String strEmoji = new String(b3, Charset.forName("utf-8"));
        System.out.println(strEmoji);


        System.out.println("=======================================");
        StringBuffer sb = new StringBuffer();
        sb.append(Character.toChars(127467));
        sb.append(Character.toChars(127479));
        System.out.println(sb);
    }
}
