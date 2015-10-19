package com.sandbox.netty.chap03;

/**
 * Author: zhangxin
 * Date:   15-10-8
 */
public class MainDriver {

    public static void showMsg(FuncApi api, String msg) {
        api.showMsg(msg);
    }

    public static void main(String[] args) {
        showMsg(FuncApi.FIRST, "111111111111111");
        showMsg(FuncApi.SECOND, "222222222222222");
    }
}
