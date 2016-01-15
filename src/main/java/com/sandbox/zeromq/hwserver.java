package com.sandbox.zeromq;

import org.zeromq.ZMQ;

/**
 * Author: zhangxin
 * Date:   16-1-15
 */
public class hwserver {

    public static void main(String ... args) throws Exception {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket responser = context.socket(ZMQ.REP);
        responser.bind("tcp://*:5555");

        while(!Thread.currentThread().isInterrupted()) {
            byte[] request = responser.recv(0);
            System.out.println("Received msg: " + new String(request));

            Thread.sleep(1000);

            String reply = "Msg from server";
            responser.send(reply.getBytes(), 0);
        }
        responser.close();
        context.term();
    }
}
