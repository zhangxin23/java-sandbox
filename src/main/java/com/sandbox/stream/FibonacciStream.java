package com.sandbox.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Author: zhangxin
 * Date:   15-11-11
 */

class FibonacciSupplier implements Supplier<Long> {
    long a = 0;
    long b = 1;

    FibonacciSupplier() {
        a = 0;
        b = 1;
    }

    @Override
    public Long get() {
        long x = a + b;
        a = b;
        b = x;
        return a;
    }
}

public class FibonacciStream {
    public static void main(String[] args) {
        FibonacciSupplier fs = new FibonacciSupplier();
        Stream<Long> fibonacci = Stream.generate(fs);
        fibonacci.limit(10).forEach(System.out::println);

        System.out.println("------------------------------------");

        FibonacciSupplier fs_1 = new FibonacciSupplier();
        Stream<Long> fibonacci_1 = Stream.generate(fs_1);
        fibonacci_1.skip(20).limit(10).forEach(System.out::println);
    }
}
