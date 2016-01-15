package com.sandbox.zeromq;

import org.zeromq.ZMQ;

/**
 * Author: zhangxin
 * Date:   16-1-15
 */
public class hwclient {

    public static void main(String ... args) {
        ZMQ.Context context = ZMQ.context(1);

        System.out.println("Connecting to Server ... ");

        ZMQ.Socket requester = context.socket(ZMQ.REQ);
        requester.connect("tcp://localhost:5555");

        for(int i = 0; i < 10; i++) {
            String request = "hello";
            System.out.println("Sending msg to server " + request);
            requester.send(request.getBytes(), 0);

            byte[] recv = requester.recv(0);
            System.out.println("Receiving msg from server [" + new String(recv) + "]");
        }

        requester.close();
        context.term();
    }
}
