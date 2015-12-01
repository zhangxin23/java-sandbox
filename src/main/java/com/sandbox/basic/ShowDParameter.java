package com.sandbox.basic;

import java.util.Properties;

/**
 * Author: zhangxin
 * Date:   15-11-30
 */
public class ShowDParameter {
    public static void printProperties(){
        Properties prop = System.getProperties();
        prop.list(System.out);
    }

    public static void main(String[] args) {
        printProperties();
    }
}
