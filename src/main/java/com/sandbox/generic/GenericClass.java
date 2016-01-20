package com.sandbox.generic;

/**
 * Author: zhangxin
 * Date:   16-1-20
 */
public class GenericClass <T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String ... args) {
        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.setObj("Generic Class");
        System.out.println(genericClass.getObj());
    }
}
