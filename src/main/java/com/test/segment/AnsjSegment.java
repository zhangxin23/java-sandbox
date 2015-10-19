package com.test.segment;

import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * Author: zhangxin
 * Date:   15-7-3
 */
public class AnsjSegment {
    public static void main(String[] args) {
        System.out.println(ToAnalysis.parse("一次性交纳五百元送话费，法轮功"));
        System.out.println(NlpAnalysis.parse("一次性交纳五百元送话费，法轮功"));
    }
}
