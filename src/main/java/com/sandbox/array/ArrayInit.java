package com.sandbox.array;

/**
 * Author: zhangxin
 * Date:   16-1-22
 */

class ArrayObject {
    private int id = 1;
}

public class ArrayInit {
    private int[] arr = new int[10];
    private ArrayObject[] objArr = new ArrayObject[10];
    private Integer[] integers = new Integer[10];

    public static void main(String [] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println(new ArrayInit().arr[i]);
        }

        System.out.println("-------------------");
        for(int i = 0; i < 10; i++) {
            System.out.println(new ArrayInit().objArr[i]);
        }

        System.out.println("-------------------");
        for(int i = 0; i < 10; i++) {
            System.out.println("Integer: " + new ArrayInit().integers[i]);
        }
    }
}
