package com.sandbox.memory;

import java.util.Vector;

/**
 * Author: zhangxin
 * Date:   16-1-22
 */

interface A {}

interface B {}

interface C extends A, B {}


public class MemLeak {

    public static void main(String ... args) {
        Vector v = new Vector(10);
        for(int i = 0; i < 100; i++) {
            v.add(new Object());
        }

        for(int i = 0; i < 10; i++) {
            System.out.println("outter for loop: " + i);
            for(int j = 0; j < 10; j++) {
                System.out.println("inner for loop: " + j);
                break;
            }
        }
    }
}
