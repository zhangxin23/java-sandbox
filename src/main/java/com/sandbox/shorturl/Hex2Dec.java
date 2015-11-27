package com.sandbox.shorturl;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-11-27
 */
public class Hex2Dec {

    public static int base10(List<Integer> base16) {
        int num = 0;
        for(Integer item: base16) {
            num = num * 16 + item;
        }
        return num;
    }

    public static void main(String[] args) {
        List<Integer> base16 = new ArrayList<Integer>(){{add(1); add(15);}};
        System.out.println(base10(base16));
    }
}
