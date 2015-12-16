package com.sandbox.inherit;

/**
 * Author: zhangxin
 * Date:   15-12-16
 */
public class Child extends Father {

    public static String NAME = "Child static variable";

    public String first = "Child first variable";

    public final String second = "Child final second variable";

    public static void main(String[] args) {
        Father father = new Father();
        System.out.println(father.NAME);

        Father father_1 = new Child();
        System.out.println(father_1.NAME);

        Child child = new Child();
        System.out.println(child.NAME);

        System.out.println("--------------------------");

        System.out.println(father.first);
        System.out.println(father_1.first);
        System.out.println(child.first);

        System.out.println("--------------------------");

        System.out.println(father.second);
        System.out.println(father_1.second);
        System.out.println(child.second);

        System.out.println("--------------------------");
        System.out.println(child.showMsg());
    }
}
