package com.sandbox.stream;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Author: zhangxin
 * Date:   15-11-11
 */

class PiSupplier implements Supplier<Double> {

    double sum = 0.0;
    double current = 1.0;
    boolean sign = true;

    @Override
    public Double get() {
        sum += (sign ? 4 : -4)/current;
        current += 2.0;
        sign = !sign;
        return sum;
    }
}

class EulerTransform implements Function<Double, Double> {

    double n1 = 0.0;
    double n2 = 0.0;
    double n3 = 0.0;

    @Override
    public Double apply(Double t) {
        n1 = n2;
        n2 = n3;
        n3 = t;
        if (n1 == 0.0) {
            return 0.0;
        }
        return calc();
    }

    double calc() {
        double d = n3 - n2;
        return n3 - d * d / (n1 - 2 * n2 + n3);
    }
}

public class PiStream {
    public static void main(String[] args) {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.skip(1000000).limit(10).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        Stream<Double> piStream_1 = Stream.generate(new PiSupplier());
        piStream_1.map(new EulerTransform())
                  .map(new EulerTransform())
                  .map(new EulerTransform())
                  .map(new EulerTransform())
                  .map(new EulerTransform())
                  .map(new EulerTransform())
                  .skip(10)
                  .limit(20).forEach(System.out::println);
    }
}
