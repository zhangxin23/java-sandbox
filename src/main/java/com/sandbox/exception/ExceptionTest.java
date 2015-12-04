package com.sandbox.exception;

/**
 * Author: zhangxin
 * Date:   15-12-3
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {

            try {
                int m = 1;
                throw new Exception("this is test");
            } catch (Exception e) {
                throw e;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
