package com.sandbox.basic;

/**
 * Author: zhangxin
 * Date:   16-1-7
 */
public class TestArray {

    public static void main(String ... args) {
        String[] len_1 = new String[1];
        len_1[0] = "first";
        for(String item: len_1) {
            System.out.println(item);
        }
        System.out.println(len_1.length);

        System.out.println("-------------------");

        String[] len_0 = new String[0];
        for(String item: len_0) {
            System.out.println(item);
        }

        System.out.println(len_0.length);

        System.out.println("------------------------");
        String[] len_2 = new String[2];
        len_2[0] = "1";
        len_2[1] = "2";
        String[] len_3 = new String[3];
        System.arraycopy(len_2, 0, len_3, 0, len_2.length);
        len_0 = len_3;
        System.out.println("len_0 = " + len_0.length);
        System.out.println("len_3 = " + len_3.length);
        for(String item: len_3) {
            System.out.println("len_3: " + item);
        }
    }
}
