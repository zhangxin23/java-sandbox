package com.sandbox.basic;


/**
 * Created by zhangxin on 2019/7/30.
 */
public class ChildClass extends ParentClass {
    private String childName = "child";

    public ChildClass() {
        this("child-child");
    }

    public ChildClass(String childName) {
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public static void main(String[] args) {
        ChildClass cc = new ChildClass();

        System.out.println("parent.name=" + cc.getParentName() + "\nchild.name=" + cc.getChildName());
    }
}
