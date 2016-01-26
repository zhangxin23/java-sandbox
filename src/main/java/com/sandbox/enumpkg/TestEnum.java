package com.sandbox.enumpkg;

/**
 * Created by zhangxin on 16/1/26.
 */

enum Color {
    Red, White, Black, Yellow;
}

public class TestEnum {
    public static void main(String ... args) {
        Color color = Color.Yellow;
        switch (color) {
            case Red:
                System.out.println("Color: Red");
                break;
            case White:
                System.out.println("Color: White");
                break;
            case Black:
                System.out.println("Color: Black");
                break;
            case Yellow:
                System.out.println("Color: Yellow");
                break;
            default:
                System.out.println("Default Color");
                break;
        }
    }
}
