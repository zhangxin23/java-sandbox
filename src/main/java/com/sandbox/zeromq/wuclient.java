package com.sandbox.zeromq;

import org.zeromq.ZMQ;

import java.util.StringTokenizer;

/**
 * Author: zhangxin
 * Date:   16-1-15
 */
public class wuclient {

    public static void main(String ... args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        subscriber.subscribe("10001 ".getBytes());

        int update_nbr = 0;
        long total_tmp = 0;
        for(update_nbr = 0; update_nbr < 100; update_nbr++) {
            String str = subscriber.recvStr(0).trim();
            System.out.println("Subscriber: " + str);

            StringTokenizer sscanf = new StringTokenizer(str, " ");
            int zipcode = Integer.valueOf(sscanf.nextToken());
            int temperature = Integer.valueOf(sscanf.nextToken());
            int relhumidity = Integer.valueOf(sscanf.nextToken());

            total_tmp +=  temperature;
        }

        System.out.println("Temperature avg for zipcode 10001 was " + (int)(total_tmp/update_nbr));

        subscriber.close();
        context.term();
    }
}
