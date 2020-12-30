package com.sandbox.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/7/22 11:49
 */
public class MainDriver {
    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter((Integer i)->i % 2 == 0).forEach(System.out::println);
        System.out.println("---------------------");
        numbers.stream().sorted((a1, a2)->a1.compareTo(a2)).forEach(System.out::println);
        System.out.println("---------------------");
        numbers.stream().sorted((a1, a2)->a1.compareTo(a2)).distinct().forEach(System.out::println);
        System.out.println("---------------------");
        numbers.stream().sorted((a1, a2)->a1.compareTo(a2)).distinct().limit(3).forEach(System.out::println);

        System.out.println("---------------------");

        List<String> dishNames = menu.stream().map(Dish::getName).collect(Collectors.toList());
        dishNames.forEach(System.out::println);
        List<Integer> dishNameLength = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        dishNameLength.forEach(System.out::println);

        String[] arrayWords = {"Hello", "world"};
        Stream<String> streamWords = Arrays.stream(arrayWords);
        streamWords.forEach(System.out::println);

        System.out.println("---------------------");
        List<String> uniqueWords = Arrays.stream(arrayWords).map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        uniqueWords.stream().forEach(System.out::print);

        System.out.println("---------------------");
        List<Integer> numberList1 = Arrays.asList(1, 2, 3);
        List<Integer> numberList2 = Arrays.asList(3, 4);
        List<int[]> pairs = numberList1.stream().flatMap(i -> numberList2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        for(int[] item: pairs) {
            System.out.println("(" + item[0] + ", " + item[1] + ")");
        }

        System.out.println("---------------------");
        List<int[]> pairs1 = numberList1.stream().flatMap(i -> numberList2.stream().filter(j -> i + j >= 6).map(j -> new int[]{i, j})).collect(Collectors.toList());
        for(int[] item: pairs1) {
            System.out.println("(" + item[0] + ", " + item[1] + ")");
        }

        System.out.println("---------------------");
        List<Integer> numberList3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numberList3.stream().reduce(0, (a, b) -> a + b));
        System.out.println(numberList3.stream().reduce(1, (a, b) -> a * b));

        System.out.println("---------------------");
        Stream<Integer> valueStream = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println("sum: " + valueStream.reduce(0, (a, b) -> a + b));
        Stream<Integer> valueStream1 = Stream.of(1, 2, 3, 4, 5, 6);
//        System.out.println("max: " + valueStream1.reduce(1, (a, b) -> a > b ? a : b));
//        System.out.println("max: " + valueStream1.reduce(Integer::max));
//        valueStream1.reduce(Integer::max).ifPresent(System.out::println);
        valueStream1.reduce(Integer::max).ifPresent(System.out::println);
    }
}
