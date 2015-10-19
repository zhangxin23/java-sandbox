package com.sandbox.annotation;

import com.sandbox.annotation.FruitColor.Color;

/**
 * Created by zhangxin on 15-4-16.
 */
public class Apple {
    @FruitName(value = "apple")
    private String appleName;

    @FruitColor(fruitColor = Color.RED)
    private String appleColor;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
}
