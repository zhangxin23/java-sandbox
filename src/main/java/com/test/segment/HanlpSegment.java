package com.test.segment;

import com.hankcs.hanlp.HanLP;

/**
 * Author: zhangxin
 * Date:   15-7-3
 */
public class HanlpSegment {
    public static void main(String[] args) {
        System.out.println(HanLP.segment("一次性交纳五百元送话费,32口交换机。法轮功"));
    }
}
