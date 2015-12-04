package com.sandbox.url;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Author: zhangxin
 * Date:   15-12-3
 */
public class UrlDecoderTest {
    private static String replaceSchema(String url) {
        if(url != url.replaceAll("[hH][tT][tT][pP]://[hH][tT][tT][pP]://", "http://")) {
            url = replaceSchema(url.replaceAll("[hH][tT][tT][pP]://[hH][tT][tT][pP]://", "http://"));
        }

        if(url != url.replaceAll("[hH][tT][tT][pP]://[hH][tT][tT][pP][sS]://", "https://")) {
            url = replaceSchema(url.replaceAll("[hH][tT][tT][pP]://[hH][tT][tT][pP][sS]://", "https://"));
        }

        if(url != url.replaceAll("[hH][tT][tT][pP][sS]://[hH][tT][tT][pP]://", "https://")) {
            url = replaceSchema(url.replaceAll("[hH][tT][tT][pP][sS]://[hH][tT][tT][pP]://", "https://"));
        }

        if(url != url.replaceAll("[hH][tT][tT][pP][sS]://[hH][tT][tT][pP][sS]://", "https://")) {
            url = replaceSchema(url.replaceAll("[hH][tT][tT][pP][sS]://[hH][tT][tT][pP][sS]://", "https://"));
        }

        return url;
    }

    public static void main(String[] args) throws Exception {
        String url = "www.baidu.com%3Fa%3D1";
        System.out.println(URLDecoder.decode(url, "UTF-8"));

        String en_url = "www.baidu.com?a=1";
        System.out.println(URLEncoder.encode(en_url, "UTF-8"));

        System.out.println(replaceSchema("https://httP://Https://http://htTP://htTps://abc.com"));

//        System.out.println("http://http://abc.com".replaceAll("http://http://", "http://"));
    }
}
