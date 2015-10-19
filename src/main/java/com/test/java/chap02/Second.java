package com.test.java.chap02;

/**
 * Created by zhangxin on 15-5-29.
 */
public class Second {
    public static void main(String[] args) {
        Class t = First.class;
        System.out.println(t.getName());

        First f = new First();
        Class t1 = f.getClass();
        System.out.println(t1.getName());

        First f1 = new First();
        try {
            Class t2 = Class.forName("com.test.java.chap02.First");
            System.out.println(t2.getName());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
