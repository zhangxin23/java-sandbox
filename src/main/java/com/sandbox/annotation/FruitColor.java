package com.sandbox.annotation;

import java.lang.annotation.*;

/**
 * Created by zhangxin on 15-4-16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color {BLUE, RED, GREEN};

    Color fruitColor() default Color.GREEN;
}
