package com.sandbox.closure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by zhangxin on 15/9/21.
 */
public class Second {

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {
            if(predicate.test(n)) {
                System.out.println(n);
            }
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> func = (Integer x)->x * x;
        System.out.println(func.apply(10));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach((n) -> System.out.println(n));

        System.out.println("print all numbers:");
        evaluate(list, (Integer n) -> true);

        System.out.println("print no numbers:");
        evaluate(list, (n) -> false);

        System.out.println("print even numbers:");
        evaluate(list, (n) -> n % 2 == 0);

        System.out.println("print odd numbers:");
        evaluate(list, (n) -> n % 2 == 1);

        System.out.println("print numbers greater than 5:");
        evaluate(list, (n) -> n > 5);

        System.out.println("print square numbers:");
        list.stream().map((x)->x * x).forEach((n) -> System.out.println(n));

        System.out.println("print sum of square numbers:");
        System.out.println(list.stream().map((x)->x * x).reduce((x, y)->x + y).get());

        System.out.println("=====================================");
        List<Integer> list_1 = Arrays.asList(5, 8, 1, 2, 6, 9);
        list_1.sort(Comparator.comparing(Integer::intValue));
        list_1.forEach(System.out::println);
    }
}
