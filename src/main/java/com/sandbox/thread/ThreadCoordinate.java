package com.sandbox.thread;

/**
 * Created by zhangxin on 2019/8/30.
 */
public class ThreadCoordinate {
    public synchronized void printOdd() {
        for(int i = 1; i < 100; i += 2) {
            System.out.println("thread_odd: " + i);
            notifyAll();

            try {
                wait();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread_odd done");
        notifyAll();
    }

    public synchronized void printEven() {
        for(int i = 0; i < 100; i += 2) {
            System.out.println("thread_even: " + i);
            notifyAll();

            try {
                wait();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread_even done");
        notifyAll();
    }

    public static void main(String[] args) {
        ThreadCoordinate tc = new ThreadCoordinate();

        Thread threadOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                tc.printOdd();
            }
        });

        Thread threadEven = new Thread(new Runnable() {
            @Override
            public void run() {
                tc.printEven();
            }
        });

        threadEven.start();
        threadOdd.start();
    }
}
