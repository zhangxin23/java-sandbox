package com.sandbox.inherit;

/**
 * Author: zhangxin
 * Date:   15-12-16
 */
public class Father {

    public static String NAME = "Father static variable";

    public String first = "Father first variable";

    public final String second = "Father final second variable";

    public final String showMsg() {
        return "Father final method showMsg";
    }
}
