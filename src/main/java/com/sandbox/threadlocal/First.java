package com.sandbox.threadlocal;

/**
 * User: zhangxin
 * Date: 2016-03-23
 * Time: 18:06:00
 */
public class First {
    public static void main(String[] args) throws Exception {
        Message msg = new Message();

        Thread first_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                msg.set(Thread.currentThread().getName());

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(msg.get());
            }
        });

        Thread second_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                msg.set(Thread.currentThread().getName());

                try {
                    Thread.sleep(6000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(msg.get());
            }
        });

        Thread third_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(msg.get());
            }
        });

        first_thread.start();
        second_thread.start();
        third_thread.start();

        Thread.currentThread().join();
    }
}
