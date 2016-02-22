package com.sandbox.pattern.lazy_init;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: zhangxin
 * Date:   16-2-22
 */
public class LazyInitiation {
    public static class PlaceHolder {
        public static final Long value = 100L;
    }

    public static final Long placeHolderValue = PlaceHolder.value;

    public static void main(String ... args) {
        int threadCount = 6;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for(int i = 0; i < threadCount; i++) {
            executorService.submit(()->System.out.println(placeHolderValue));
        }
        executorService.shutdown();
    }
}
