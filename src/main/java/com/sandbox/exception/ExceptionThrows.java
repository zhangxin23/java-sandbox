package com.sandbox.exception;

/**
 * User: zhangxin
 * Date: 2016-10-26
 * Time: 13:50:00
 */
public class ExceptionThrows {

    public void testFuncThrow() throws Exception {
        try {
            System.out.println("enter try clause");
            throw new MyException("test");
        } catch (Exception e) {
            throw e;
        }
    }

    public void testFuncCatch() {
        try {
            testFuncThrow();
        } catch (MyException e) {
            System.out.println("catch MyException");
        } catch (Exception e) {
            System.out.println("catch Exception");
        }
    }

    public static void main(String[] args) {
        new ExceptionThrows().testFuncCatch();
    }
}
