package com.test.java.chap03;

/**
 * Author: zhangxin
 * Date:   15-7-21
 */
public class InterfaceExceptionImpl implements InterfaceException {

    @Override
    public void showMsg(String info) throws IllegalArgumentException {
        if(info == null)
            throw new IllegalArgumentException("argument is null.");

    }
}
