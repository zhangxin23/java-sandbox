package com.sandbox.stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: zhangxin
 * Date:   15-11-17
 */
public class Counter {
    public static void main(String[] args) {
        String[] arr = { "program", "creek", "program", "creek", "java", "web",
                "program" };
        Stream<String> stream = Stream.of(arr).parallel();
        Map<String, Long> counter = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        for(Map.Entry<String, Long> item: counter.entrySet())
            System.out.println("key: " + item.getKey() + ", value: " + item.getValue());
    }
}
