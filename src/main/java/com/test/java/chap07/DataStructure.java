package com.test.java.chap07;

import java.util.*;

/**
 * Author: zhangxin
 * Date:   15-9-22
 */
public class DataStructure {
    public static void func_iterator() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void func_enumeration() {
        Hashtable<String, Integer> hash = new Hashtable<>();
        hash.put("first", 1);
        hash.put("second", 2);

        Enumeration<Integer> enumeration = hash.elements();
        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    public static void func_bitset() {
        BitSet bs = new BitSet(10);
        System.out.println(bs.toString());
        bs.set(1);
        bs.set(3);
        System.out.println(bs.toString());
        if(bs.get(1))
            System.out.println("The 1 bit is set.");
    }

    public static void func_vector() {
        Vector<Integer> vector = new Vector<>(10);
        for(int i = 1; i < 11; i++)
            vector.add(i);

        for(int idx = 0; idx < 10; idx++)
            System.out.println(vector.get(idx));
    }

    public static void func_stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        while(!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void func_dictionary() {
        Properties properties = new Properties();
        properties.put("first", "1");
        properties.put("second", "2");
        System.out.println(properties.get("first"));
        System.out.println(properties.get("second"));
    }

    public static void main(String[] args) {
        func_iterator();
        System.out.println("====================================");
        func_enumeration();
        System.out.println("====================================");
        func_bitset();
        System.out.println("====================================");
        func_vector();
        System.out.println("====================================");
        func_stack();
        System.out.println("====================================");
        func_dictionary();
    }
}
