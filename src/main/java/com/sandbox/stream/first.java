package com.sandbox.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Author: zhangxin
 * Date:   15-9-1
 */
public class first {
    public static void main(String[] args) {
        IntStream.of(new int[] {1, 2, 3}).forEach(System.out::println);

        System.out.println("======================================");

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(toList());
        for(Integer item: squareNums) {
            System.out.println(item);
        }

        System.out.println("======================================");
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

        outputStream.forEach(System.out::println);

        System.out.println("======================================");
        int ret = Optional.ofNullable("").map(String::length).orElse(-1);
        int ret_1 = Optional.ofNullable("12345").map(String::length).orElse(-1);
        System.out.println("ret = " + ret + "   ret_1 = " + ret_1);

        System.out.println("======================================");
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("concat is " + concat);

        System.out.println("======================================");

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", 1));
        persons.add(new Person("b", 0));
        persons.add(new Person("c", 1));
        persons.add(new Person("d", 1));
        persons.add(new Person("e", 1));
        persons.add(new Person("f", 0));
        persons.add(new Person("g", 1));
        persons.add(new Person("h", 0));
        persons.add(new Person("i", 1));

//        List<Integer> transactionsIds = transactions.parallelStream().
//                filter(t -> t.getType() == Transaction.GROCERY).
//                sorted(comparing(Transaction::getValue).reversed()).
//                map(Transaction::getId).
//                collect(toList());

        List<String> personNames = persons.parallelStream().
                filter(item -> item.getSex() == 1).
                sorted(comparing(Person::getName).reversed()).
                map(Person::getName).collect(toList());

        for(String item: personNames)
            System.out.println(item);
    }
}
