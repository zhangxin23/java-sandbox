package com.test.java.chap03;

/**
 * Author: zhangxin
 * Date:   15-7-6
 */
public class Third {
    public static String setStr(String txt) {
        String resultTxt = txt;
        resultTxt += " Func setStr";
        return resultTxt;
    }

    public static void main(String[] args) {
        String txt = "hello";
        String retTxt = setStr(txt);
        System.out.println("retTxt: " + retTxt);
        System.out.println("txt: " + txt);
    }
}
