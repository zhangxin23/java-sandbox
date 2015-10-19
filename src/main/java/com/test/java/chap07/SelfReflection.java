package com.test.java.chap07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Author: zhangxin
 * Date:   15-9-22
 */
public class SelfReflection {

    private String info = "hello";

    public static void methodA() {
        System.out.println("methodA...");
    }

    public static void main(String[] args) throws Exception {
        Method[] methods = SelfReflection.class.getMethods();
        for(Method item: methods) {
            System.out.println("method: " + item.getName());
        }

        Class instance = Class.forName("com.test.java.chap07.SelfReflection");
        System.out.println("" + instance.getName());
        System.out.println("" + instance.getSimpleName());
        System.out.println("" + instance.getModifiers());
        System.out.println("modifiers of this class is public? " + Modifier.isPublic(instance.getModifiers()));
        System.out.println("" + instance.getPackage());
        System.out.println("" + instance.getSuperclass());

        System.out.println("=================================");
        Class[] interfaceClasses = instance.getInterfaces();
        for(Class item: interfaceClasses)
            System.out.println(item.getName());

        System.out.println("=================================");
        Constructor[] constructors = instance.getConstructors();
        for(Constructor item: constructors)
            System.out.println(item.getName());

        System.out.println("=================================");
        Field[] fields = instance.getFields();
        for(Field item: fields)
            System.out.println(item.getName());

//        Annotation[] annotations =
    }
}
