package com.sandbox.stream;

import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

/**
 * Author: zhangxin
 * Date:   15-11-13
 */
public class TestParallelStream {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.range(1, 45).parallel().map(TestParallelStream::fib).sum();
        stopWatch.stop();
        System.out.println("Parallel took " + stopWatch.getTime() + " ms");

        stopWatch.reset();
        stopWatch.start();
        IntStream.range(1, 45).map(TestParallelStream::fib).sum();
        stopWatch.stop();
        System.out.println("Sequential took " + stopWatch.getTime() + " ms");
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
