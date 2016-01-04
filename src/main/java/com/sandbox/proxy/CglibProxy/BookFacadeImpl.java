package com.sandbox.proxy.CglibProxy;

/**
 * Author: zhangxin
 * Date:   16-1-4
 */
public class BookFacadeImpl implements BookFacade{

    @Override
    public void addBook() {
        System.out.println("add book method ... ");
    }
}
