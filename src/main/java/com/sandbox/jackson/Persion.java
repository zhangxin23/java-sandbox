package com.sandbox.jackson;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by zhangxin on 15-4-3.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Persion {
    private String name;
    private String sex;
    private Integer age;

    public Persion(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Persion() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
