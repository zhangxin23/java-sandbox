package com.sandbox.zeromq;

import org.zeromq.ZMQ;

/**
 * Author: zhangxin
 * Date:   16-1-15
 */
public class tasksink {

    public static void main(String ... args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket sink = context.socket(ZMQ.PULL);
        sink.bind("tcp://*:5558");

        String count = new String(sink.recv());
        System.out.println("Recv from event server: " + count);

        long t_start = System.currentTimeMillis();
        for(int i = 0; i < Integer.parseInt(count); i++) {
            System.out.println("Recv from work server[" + i + "]: " + sink.recvStr());

//            if((i / 10) * 10 == i) {
//                System.out.println(":");
//            } else {
//                System.out.println(".");
//            }
        }

        long t_end = System.currentTimeMillis();
        System.out.println("\nTotal elapsed time: " + (t_end - t_start));

        sink.close();
        context.term();
    }
}
