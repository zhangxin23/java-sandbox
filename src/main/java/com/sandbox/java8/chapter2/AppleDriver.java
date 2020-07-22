package com.sandbox.java8.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/21 10:21
 */
public class AppleDriver {
    private static List<Apple> appleList = new ArrayList<>();
    static {
        appleList.add(new Apple("green", 100));
        appleList.add(new Apple("green", 160));
        appleList.add(new Apple("green", 200));
        appleList.add(new Apple("red", 100));
        appleList.add(new Apple("red", 160));
        appleList.add(new Apple("red", 200));
    }

    public static void prettyPrintApple(List<Apple> appleList, AppleFormatter formatter) {
        for(Apple apple: appleList) {
            System.out.println(formatter.accept(apple));
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T> void showList(List<T> list) {
        for(T t: list) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        prettyPrintApple(appleList, new AppleFancyFormatter());
        System.out.println("-------------------------------------");
        prettyPrintApple(appleList, new AppleSimpleFormatter());
        System.out.println("-------------------------------------");
        prettyPrintApple(appleList, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                String color = apple.getColor();
                if(color.equalsIgnoreCase("green"))
                    return "green apple";
                else if(color.equalsIgnoreCase("red"))
                    return "red apple";
                else
                    return "other color apple";
            }
        });
        System.out.println("------------------------------------");
        prettyPrintApple(appleList, (Apple apple)->"weight: " + apple.getWeight() + ", color: " + apple.getColor());
        System.out.println("------------------------------------");
        List<Apple> resultList = filter(appleList, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                if(apple.getColor().equals("red"))
                    return true;
                else
                    return false;
            }
        });
        showList(resultList);
        System.out.println("------------------------------------");
        showList(filter(appleList, (Apple apple)->apple.getColor().equals("green")));
        System.out.println("------------------------------------");
        showList(filter(appleList, (Apple apple)->apple.getWeight()>150));
        System.out.println("------------------------------------");
        showList(filter(appleList, (Apple apple)->apple.getWeight()>150 && apple.getColor().equals("red")));
        System.out.println("------------------------------------");
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                if(o1.getWeight() < o2.getWeight())
                    return -1;
                else if(o1.getWeight() == o2.getWeight())
                    return 0;
                else
                    return 1;
            }
        });
        showList(appleList);

        System.out.println("------------------------------------");
        List<Integer> numbers = Arrays.asList(1, 5, 7, 2, 3);
        System.out.println(numbers);
//        numbers.sort(Comparator.naturalOrder());
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                if(o1 > o2)
//                    return 1;
//                else
//                    return 0;
//                return o1.compareTo(o2);
                return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
            }
        });
        System.out.println(numbers);

        System.out.println("------------------------------------");
        Thread t = new Thread(()->System.out.println("Hello world"));
        t.start();
    }
}
