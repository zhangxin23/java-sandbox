package com.sandbox.netty.chap03;

/**
 * Author: zhangxin
 * Date:   15-10-8
 */
public interface FuncApi {
    FuncApi FIRST = new FuncApi() {
        public void showMsg(String msg) {
            System.out.println("FIRST: " + msg);
        }
    };

    FuncApi SECOND = new FuncApi() {
        public void showMsg(String msg) {
            System.out.println("SECOND: " + msg);
        }
    };

    void showMsg(String msg);
}
