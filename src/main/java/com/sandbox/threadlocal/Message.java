package com.sandbox.threadlocal;

/**
 * User: zhangxin
 * Date: 2016-03-23
 * Time: 18:07:00
 */
public class Message {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Default value";
        }
    };

    public void set(String msg) {
        threadLocal.set(msg);
    }

    public String get() {
        return threadLocal.get();
    }
}
