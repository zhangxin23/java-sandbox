package com.sandbox.basic;

/**
 * Author: zhangxin
 * Date:   16-2-22
 */
public class UnsignedInt {

    public static int getUnsignedByte(byte data) {
        return ((int) data) & 0xFF;
    }

    public static int getUnsignedShort(short data) {
        return ((int) data) & 0xFFFF;
    }

    public static long getUnsignedInt(int data) {
        return ((long) data) & 0xFFFFFFFFL;
    }

    public static void main(String[] args) {
        byte byte_1 = 1;
        System.out.println(getUnsignedByte(byte_1));

        byte byte_2 = -1;
        System.out.println(getUnsignedByte(byte_2));

        byte byte_3 = -128;
        System.out.println(getUnsignedByte(byte_3));
    }
}
