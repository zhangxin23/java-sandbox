package com.test.first;

/**
 * Created by zhangxin on 15-6-17.
 */
public class MultiTest implements Runnable {
    private IdGetter idGetter = new IdGetter();

    public void run() {
        long id = idGetter.getId(101);
        System.out.println(id);
//        long timestamp = id >> 24;
//        long machineId = id >> 12 & 0xFFF;
//        long sequence = id & 0xFFF;
//        System.out.println("timestamp: " + (timestamp + 1420041600000L));
//        System.out.println("machineId: " + machineId);
//        System.out.println("sequence: " + sequence);
    }

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            MultiTest mt = new MultiTest();
            for(int i = 0 ; i < 10000000; i++) {
                Thread thread_a = new Thread(mt);
                thread_a.start();
            }
            System.out.println("times: " + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
