package com.sandbox.array;

/**
 * Created by zhangxin on 17/3/13.
 */
public class ArrayParameter {

    public static void setArray(int[] a, int value) {
        a[0] = value;
    }

    public static void main(String []args) {
//        int[] array = new int[] {1, 2, 3, 4, 5, 6};
//
//        setArray(array, 99);
//
//        for(int item: array) {
//            System.out.println(item);
//        }

        String pushMsg = "骑手更换为{123}{abc}{123456789}。|骑手更换为{123}{abc}";
        String[] msgList = pushMsg.split("\\|");
        if(msgList.length >= 2) {
            pushMsg = msgList[0];
        }
        System.out.println("------" + pushMsg + "------");
    }
}
