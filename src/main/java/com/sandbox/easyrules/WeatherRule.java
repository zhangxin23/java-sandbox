package com.sandbox.easyrules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/10/27 15:36
 */
@Rule(name = "weather rule", description = "if it rains then take an umbrella")
public class WeatherRule {
    @Condition
    public boolean itRains(@Fact("rain") boolean rain) {
        return rain;
    }

    @Action
    public void takeAnUmbrella() {
        System.out.println("It rains, take an umbrella");
    }
}
