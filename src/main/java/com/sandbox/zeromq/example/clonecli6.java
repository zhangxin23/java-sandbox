package com.sandbox.zeromq.example;/*
 *     clonecli6.java
 *
 */


import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Clone client model 6
 */
public class clonecli6
{
    private final static String SUBTREE = "/client/";
	public void run() {

        //  Create distributed hash instance
        clone clone = new clone();
        Random rand = new Random(System.nanoTime());

        //  Specify configuration
        clone.subtree(SUBTREE);
        clone.connect("tcp://localhost", "5556");
        clone.connect("tcp://localhost", "5566");

        //  Set random tuples into the distributed hash
        while (!Thread.currentThread().isInterrupted()) {
            //  Set random value, check it was stored
            String key = String.format("%s%d", SUBTREE, rand.nextInt(10000));
            String value= String.format("%d", rand.nextInt(1000000));
            clone.set(key, value, rand.nextInt(30));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        clone.destroy();
	}

	public static void main(String[] args) {
		new clonecli6().run();
	}
}
