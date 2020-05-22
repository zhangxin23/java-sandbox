package com.sandbox.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2019/9/3.
 */
public class SetFinalTest {
    public final Map<String, String> FINAL_MAP = new HashMap<>();

    public SetFinalTest() {
        FINAL_MAP.put("1", "one");
        FINAL_MAP.put("2", "two");
    }

    public Map<String, String> getFINAL_MAP() {
        return FINAL_MAP;
    }

    public void setFINAL_MAP(String key, String value) {
        FINAL_MAP.put(key, value);
    }

    public static void main(String[] args) {
        SetFinalTest setFinalTest = new SetFinalTest();

        System.out.println("1--" + setFinalTest.getFINAL_MAP().get("1"));
        System.out.println("2--" + setFinalTest.getFINAL_MAP().get("2"));

        setFinalTest.setFINAL_MAP("3", "three");
        System.out.println("3--" + setFinalTest.getFINAL_MAP().get("3"));
    }
}
