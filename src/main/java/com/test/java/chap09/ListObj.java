package com.test.java.chap09;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-10-16
 */

class TestInnerObj {
    private String item1;
    private Double item2;

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public Double getItem2() {
        return item2;
    }

    public void setItem2(Double item2) {
        this.item2 = item2;
    }
}

class TestObj {
    private String name;
    private String test;
    private Integer age;
    private TestInnerObj testInnerObj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TestInnerObj getTestInnerObj() {
        return testInnerObj;
    }

    public void setTestInnerObj(TestInnerObj testInnerObj) {
        this.testInnerObj = testInnerObj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObj testObj = (TestObj) o;

        if (name != null ? !name.equals(testObj.name) : testObj.name != null) return false;
        if (test != null ? !test.equals(testObj.test) : testObj.test != null) return false;
        if (age != null ? !age.equals(testObj.age) : testObj.age != null) return false;
        return !(testInnerObj != null ? !testInnerObj.equals(testObj.testInnerObj) : testObj.testInnerObj != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (testInnerObj != null ? testInnerObj.hashCode() : 0);
        return result;
    }
}

public class ListObj {
    public static void main(String[] args) {
        List<TestObj> objList = new ArrayList<>();
        TestObj obj1 = new TestObj();
        TestObj obj2 = new TestObj();
        objList.add(obj1);
        objList.add(obj2);



    }
}
