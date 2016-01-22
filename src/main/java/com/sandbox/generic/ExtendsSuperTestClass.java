package com.sandbox.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   16-1-20
 */

class Food {

}

class Fruit extends Food {

}

class Apple extends Fruit {

}

public class ExtendsSuperTestClass {
    public static void main(String ... args) {
//        List<? extends Food> foodList = new ArrayList<>();
//        foodList.add(new Food());
//        foodList.add(new Fruit());
//        foodList.add(new Apple());
//
//        List<? super Fruit> fruitList = new ArrayList<>();
//        fruitList.add(new Food());
//        fruitList.add(new Fruit());
//        fruitList.add(new Apple());
    }
}
