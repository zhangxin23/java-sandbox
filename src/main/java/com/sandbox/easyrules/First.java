package com.sandbox.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.File;
import java.io.FileReader;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/10/27 14:36
 */
public class First {
    public static void main(String[] args) {
        Facts facts = new Facts();
        facts.put("rain", true);
        facts.put("cloud", true);

//        WeatherRule rule = new WeatherRule();

        Rule weatherMVELRule = new MVELRule()
                .name("weather mvel rule")
                .description("if it rains then take an umbrella")
                .when("rain == true && cloud == false")
                .then("System.out.println(\"It rains, take an umbrella!\");");

        Rules rules = new Rules();
        rules.register(weatherMVELRule);

//        Rules rules = new Rules();
//        try {
//            String filePath = System.getProperty("user.dir") + "/src/main/resources/WeatherRuleYam.yam";
//            rules = MVELRuleFactory.createRulesFrom(new FileReader(filePath));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}
