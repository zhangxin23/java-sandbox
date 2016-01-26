package com.sandbox.pattern.singleton;

/**
 * Created by zhangxin on 16/1/26.
 */

public enum Singleton {
    INTSTANCE;

    private int id = 0;

    private Singleton() {
        System.out.println("==Begin Constructor==");
        id = 1;
    }

    public int getId() {
        return id++;
    }

    public static void main(String ... args) {
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
        System.out.println(Singleton.INTSTANCE.getId());
    }
}