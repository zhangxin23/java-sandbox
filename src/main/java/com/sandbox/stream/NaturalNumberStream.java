package com.sandbox.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Author: zhangxin
 * Date:   15-11-11
 */

class NaturalSupplier implements Supplier<Long> {

    long value = 0;

    public Long get() {
        this.value = this.value + 1;
        return this.value;
    }
}

public class NaturalNumberStream {

    public static void main(String[] args) {
        Stream<Long> natural = Stream.generate(new NaturalSupplier());
        natural.map(x -> x * x).limit(20).filter(x -> !(x % 2 != 0)).forEach(System.out::println);
    }
}
