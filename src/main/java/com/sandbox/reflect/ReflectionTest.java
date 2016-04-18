package com.sandbox.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * User: zhangxin
 * Date: 2016-04-17
 * Time: 17:19:00
 */
public class ReflectionTest {
    public static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getDeclaredConstructors();
        for(Constructor c: constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0)
                    System.out.print(", ");

                System.out.print(paramTypes[j].getName());
            }
        }
        System.out.println(");");
    }

    public static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for(Method m: methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class c1) {
        Field[] fields = c1.getDeclaredFields();
        for(Field f: fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");

            System.out.println(type.getName() + " " + name + ";");
        }
    }

    public static void main(String[] args) {
        String name = "com.sandbox.reflect.ObjectAnalyzer";
        try {
            Class c1 = Class.forName(name);
            Class superC1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");

            System.out.print("class " + name);

            if(superC1 != null && superC1 != Object.class)
                System.out.print(" extends " + superC1.getName());

            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
