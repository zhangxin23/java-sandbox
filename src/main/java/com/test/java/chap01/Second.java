package com.test.java.chap01;

/**
 * Created by zhangxin on 15-5-14.
 */

class Level1 {
    private String name;

//    public Level1() {
//        name = "default";
//    }

    public Level1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Level2 extends Level1 {
    private int age;

    public Level2(int age) {
        super("level1");
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Second {
    public static void main(String[] args) {
        Level2 level2 = new Level2(1);

        System.out.println("level.name = " + level2.getName() + "  age = " + level2.getAge());
    }
}
