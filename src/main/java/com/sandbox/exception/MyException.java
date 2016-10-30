package com.sandbox.exception;

/**
 * User: zhangxin
 * Date: 2016-10-26
 * Time: 13:50:00
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
