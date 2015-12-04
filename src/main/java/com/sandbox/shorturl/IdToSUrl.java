package com.sandbox.shorturl;

/**
 * Author: zhangxin
 * Date:   15-12-3
 */
public class IdToSUrl {
    private static final String SURL_CHARSET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String idToSUrl(long id) {
        StringBuilder builder = new StringBuilder();
        while(id > 0) {
            builder.append(SURL_CHARSET.charAt((int)(id % 62)));
            id /= 62;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(idToSUrl(9999999999l));
    }
}
