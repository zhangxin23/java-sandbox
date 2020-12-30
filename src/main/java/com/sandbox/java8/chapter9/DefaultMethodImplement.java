package com.sandbox.java8.chapter9;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/27 14:48
 */
public class DefaultMethodImplement implements DefaultMethod {
    public void accept(String value) {
        System.out.println("accept method: " + value);
    }

    public static void main(String[] args) {
        DefaultMethod implementMethod = new DefaultMethodImplement();
        implementMethod.accept("111");
        implementMethod.show("222");
        DefaultMethod.showShow("333");
    }
}
