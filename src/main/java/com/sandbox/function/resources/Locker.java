package com.sandbox.function.resources;

import java.util.concurrent.locks.Lock;

/**
 * Author: zhangxin
 * Date:   15-12-17
 */
public class Locker {
    public static void runLocked(Lock lock, Runnable block) {
        lock.lock();
        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }
}
