package com.sandbox.encrypt.des_aes;

/**
 * Author: zhangxin
 * Date:   15-11-24
 */
public class Main {
    public static void test() throws Exception {
        String inputStr = "ABCDEFGHIJK";
        String key = DESCoder.initKey();
        System.err.println("密钥:\t" + key);

        System.err.println("原文:\t" + inputStr);

        byte[] inputData = inputStr.getBytes();
        inputData = DESCoder.encrypt(inputData, key);

        System.err.println("加密后:\t" + DESCoder.encryptBASE64(inputData));

        byte[] outputData = DESCoder.decrypt(inputData, key);
        String outputStr = new String(outputData);

        System.err.println("解密后:\t" + outputStr);
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
