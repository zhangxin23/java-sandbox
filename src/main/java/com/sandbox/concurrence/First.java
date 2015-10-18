package com.sandbox.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangxin on 15/10/17.
 */
public class First {
    //ExecutorService call Runnable task.
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 5; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " is called.");
//                }
//            });

            executorService.execute(()->System.out.println(Thread.currentThread().getName() + " is called."));
        }

        executorService.shutdown();
    }
}
