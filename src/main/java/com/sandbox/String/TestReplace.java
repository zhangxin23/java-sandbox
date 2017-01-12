package com.sandbox.String;

import java.math.BigDecimal;

/**
 * User: zhangxin
 * Date: 2016-12-01
 * Time: 10:06:00
 */
public class TestReplace {

    public static void main(String[] args) {
        String tgtBlock = "[\"b_optimization_channel\", \"b_specialty_channel\", \"b_adbanner\"]";
        System.out.println(tgtBlock);
        tgtBlock = tgtBlock.replaceAll("\\s*", "");
        System.out.println(tgtBlock);


        Double d = 123.567;
        System.out.println(d.intValue());


        System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.5)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入取整:(2.9)=" + new BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));
    }
}
