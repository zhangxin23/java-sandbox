package com.sandbox.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * User: zhangxin
 * Date: 2016-08-23
 * Time: 20:25:00
 */
public class InnerClassStatic {
    public static final Map<InnerTest, Integer> INNER_TEST_INTEGER_MAP = new HashMap<InnerTest, Integer>() {
        {
            put(InnerTest.INNER_TEST_1, 1);
            put(InnerTest.INNER_TEST_2, 2);
        }
    };

    public static class InnerTest {
        public static final InnerTest INNER_TEST_1 = new InnerTest(1);
        public static final InnerTest INNER_TEST_2 = new InnerTest(2);

        private int value = 1;

        public InnerTest(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            InnerTest innerTest = (InnerTest) o;

            return value == innerTest.value;

        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    public static int getInnerTest(InnerTest innerTest) {
        return INNER_TEST_INTEGER_MAP.get(innerTest);
    }

    public static void main(String[] args) {
        InnerTest innerTest = new InnerTest(1);
        System.out.println(InnerClassStatic.getInnerTest(innerTest));
    }
}
