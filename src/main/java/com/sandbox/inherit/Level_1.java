package com.sandbox.inherit;

/**
 * Author: zhangxin
 * Date:   16-1-22
 */
public class Level_1 extends Level_0 {
    private String id;

    public Level_1(String id) {
        super("first");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void main(String ... args) {
        Level_1 obj = new Level_1("1");
        System.out.println(obj.getName() + "-->" + obj.getId());

        double val = 1.1;
        byte by = (byte)val;
        System.out.println("double val = " + val);
        System.out.println("byte by = " + by);
    }
}
