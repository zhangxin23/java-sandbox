package com.sandbox.zeromq;

import org.zeromq.ZMQ;

/**
 * Author: zhangxin
 * Date:   16-1-15
 */
public class taskwork {

    public static void main(String ... args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket receiver = context.socket(ZMQ.PULL);
        receiver.connect("tcp://localhost:5557");

        ZMQ.Socket sender = context.socket(ZMQ.PUSH);
        sender.connect("tcp://localhost:5558");

        while (!Thread.currentThread ().isInterrupted ()) {
            String s_time = new String(receiver.recv(0)).trim();
            System.out.flush();
            System.out.print(s_time + '.');

            Thread.sleep(Long.parseLong(s_time));

            sender.send("1".getBytes(), 0);
        }

        sender.close();
        receiver.close();
        context.term();
    }
}
