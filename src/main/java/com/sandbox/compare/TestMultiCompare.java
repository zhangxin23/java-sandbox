package com.sandbox.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2016-10-26
 * Time: 10:08:00
 */
public class TestMultiCompare {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<Student>();
        students.add(new Student("zhangsan",21,3000,180));
        students.add(new Student("zhangsan",27,4000,180));
        students.add(new Student("zhangsan",15,1000,180));
        students.add(new Student("zhangsan",21,5000,180));
        students.add(new Student("zhangsan",45,4000,180));
        students.add(new Student("zhangsan",21,5000,174));
        students.add(new Student("zhangsan",20,4000,180));
        students.add(new Student("zhangsan",33,4000,180));
        students.add(new Student("zhangsan",45,4000,180));
        students.add(new Student("zhangsan",76,4000,180));
        students.add(new Student("zhangsan",99,4000,180));
        students.add(new Student("zhangsan",21,5000,160));

        Collections.sort(students, new Comparator<Student>(){
            public int compare(Student a1, Student a2) {
                int x = a1.getAge() - a2.getAge();
                int y = a1.getSalary() - a2.getSalary();
                int z = a1.getHeight() - a2.getHeight();
                if(x==0){
                    if(y==0){
                        return z;
                    }
                    return y;
                }
                return x;
            }

        });

        for(Student s:students){
            System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getSalary()+"\t"+s.getHeight());
        }
    }
}



class Student{

    Student(String name,int age,int salary,int height){

        this.name=name;
        this.age=age;
        this.salary=salary;
        this.height=height;

    }
    private String name;

    private int  age;

    private int salary;

    private int height;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
