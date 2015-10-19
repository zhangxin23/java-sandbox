package com.sandbox.idgenerator;

/**
 * Created by zhangxin on 15-3-24.
 */
public class InvalidSystemClockException extends Exception {
    public InvalidSystemClockException(String message){
        super(message);
    }
}
