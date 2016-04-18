package com.sandbox.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * User: zhangxin
 * Date: 2016-04-17
 * Time: 17:03:00
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if(obj == null)
            return "null";

        if(visited.contains(obj))
            return "...";

        visited.add(obj);

        Class c1 = obj.getClass();
        if(c1 == String.class)
            return (String)obj;

        if(c1.isArray()) {
            String r = c1.getComponentType() + "[]{";
            for(int i = 0; i < Array.getLength(obj); i++) {
                if(i > 0)
                    r += ",";
                Object val = Array.get(obj, i);
                if(c1.getComponentType().isPrimitive())
                    r += val;
                else
                    r += toString(val);
            }
            return r + "}";
        }

        String r = c1.getName();
        do{
            r += "[";
            Field[] fields = c1.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for(Field f: fields) {
                if(!Modifier.isStatic(f.getModifiers())) {
                    if(!r.endsWith("["))
                        r += ",";

                    r += f.getName() + "=";

                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if(t.isPrimitive())
                            r += val;
                        else
                            r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r+= "]";
            c1 = c1.getSuperclass();
        } while(c1 != null);

        return r;
    }

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
