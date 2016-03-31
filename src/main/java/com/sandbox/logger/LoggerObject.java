package com.sandbox.logger;

/**
 * User: zhangxin
 * Date: 2016-03-24
 * Time: 20:43:00
 */
public class LoggerObject {
    private String name = "";
    private int age = 0;
    private double first = 0.0;

    public LoggerObject() {

    }

    public LoggerObject(String name, int age, double first) {
        this.name = name;
        this.age = age;
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }
}
