package com.sandbox.proxy.pattern;

/**
 * Author: zhangxin
 * Date:   16-1-4
 */
public class Main {

    public static void main(String ... args) {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.request();
    }
}
