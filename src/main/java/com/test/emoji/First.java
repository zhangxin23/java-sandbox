package com.test.emoji;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangxin on 15-6-11.
 */
public class First {
    public static void main(String[] args) {
//        String emoji = new StringBuilder()
//                .appendCodePoint(0x1F601)
//                .appendCodePoint(0x1F602)
//                .toString();

        //unicode: 0x1F601; utf-16: 0xD83D 0xDE01; utf-8: 0xF0 0x9F 0x98 0x81

        String emojiStr_1 = "\uD83D\uDE01\uD83D\uDE02";
        String emojiStr_2 = "\uD83D\uDE02";

        byte[] emojiBytes = emojiStr_1.getBytes();
        for(byte item: emojiBytes)
            System.out.println((int)item);

        System.out.println("-------------------------");
        System.out.println((byte)0xF0);
        System.out.println((byte)0x9F);
        System.out.println((byte)0x98);
        System.out.println((byte)0x81);

        System.out.println("-------------------------");
        String input = "\uD83D\uDE01";
//        String input = new StringBuilder().appendCodePoint(0x1F601).append("asdfas").toString();
//        Pattern pattern = Pattern.compile("[\\uD83D\\uDE01]");
        Pattern pattern = Pattern.compile("[\\uD800-\\uDBFF][\\uDC00-\\uDFFF]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            System.out.println("Find!");
        else
            System.out.println("Not Find!");

        System.out.println("--------------------------");
//        String str = "\uD83D\uDE00\uD83D\uDE01\uD83D\uDE02\uD83D\uDE03\uD83D\uDE04";
        String str = "1234123\uD83D\uDE01asdfa123412341\uD83D\uDE02";
//        String pattern_1 = "[\\uD800-\\uDBFF][\\uDC00-\\uDFFF]";
        String pattern_1 = "([\\x{10000}-\\x{10FFFF}])";

        Pattern r = Pattern.compile(pattern_1);
        Matcher m = r.matcher(str);
        System.out.println(m.find());
        System.out.println(m.groupCount());
        while(m.find()) {
            System.out.println(m.group(1));
        }
    }
}
