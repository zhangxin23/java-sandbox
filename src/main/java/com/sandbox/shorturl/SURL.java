package com.sandbox.shorturl;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: zhangxin
 * Date:   15-11-27
 */
public class SURL {
    private final static String MD5_KEY = "shorted_url";
    private final static String TABLE = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public static String bytes2HexStr(byte[] bytes) {
        String result = "";
        for(int i = 0; i < bytes.length; i++) {
            result += DIGITS_UPPER[bytes[i] & 0xF0 >>> 4];
            result += DIGITS_UPPER[bytes[i] & 0x0F];
        }
        return result;
    }

    public static byte[] expandBytes(byte[] bytes) {
        if(bytes.length < 32) {
            byte[] resizeMd5Bytes = new byte[32];
            for(int i = 0; i < bytes.length; i++)
                resizeMd5Bytes[i] = bytes[i];
            for(int i = bytes.length; i < 32; i++) {
                resizeMd5Bytes[i] = 0;
            }

            return resizeMd5Bytes;
        } else {
            return bytes;
        }
    }

    public static String urlShorten(String url) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((MD5_KEY + url).getBytes());
        byte[] md5Bytes = md5.digest();
        String hexStr = bytes2HexStr(expandBytes(md5Bytes));

        List<String> resList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            String subStr = hexStr.substring(i * 8, i * 8 + 8);
            long num = Long.parseLong(subStr, 16);
            num &= 0x000000003FFFFFFF;

            String resTmp = "";
            for(int j = 0; j < 6; j++) {
                resTmp += TABLE.charAt((int)(num & 0x000000000000003D));
                num >>= 5;
            }

            resList.add(resTmp);
        }

        Random random = new Random();
        return resList.get(random.nextInt(4));
    }


    public static void main(String[] args) throws Exception {
        System.out.println(urlShorten("www.baidu.comasdfasdfasdf"));
    }
}
