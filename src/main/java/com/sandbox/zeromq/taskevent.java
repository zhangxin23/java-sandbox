package com.sandbox.zeromq;

import org.zeromq.ZMQ;

import java.util.Random;

/**
 * Author: zhangxin
 * Date:   16-1-15
 */
public class taskevent {

    public static void main(String ... args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket sender = context.socket(ZMQ.PUSH);
        sender.bind("tcp://*:5557");

        ZMQ.Socket sink = context.socket(ZMQ.PUSH);
        sink.connect("tcp://localhost:5558");

        System.out.println("Press Enter when the workers are ready: ");
        System.in.read();
        System.out.println("Sending tasks to workers\n");

        int count = 111;
        sink.send("" + count, 0);

        Random srandom = new Random(System.currentTimeMillis());

        int task_nbr;
        int total_msec = 0;
        for (task_nbr = 0; task_nbr < count; task_nbr++) {
            int workload = srandom.nextInt(100) + 1;
            total_msec += workload;
            System.out.print(workload + ".");
            String str = String.format("%d", workload);
            sender.send(str, 0);
        }
        System.out.println("\nTotal expected cost: " + total_msec + " msec");
        Thread.sleep(1000);

        sink.close();
        sender.close();
        context.term();
    }
}
