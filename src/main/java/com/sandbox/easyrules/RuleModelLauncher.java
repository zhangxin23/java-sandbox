package com.sandbox.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/10/27 18:19
 */
public class RuleModelLauncher {
    public static void main(String[] args) {
        RuleModel model = new RuleModel();
        model.setName("AAA");
        model.setValue(19);

        Facts facts = new Facts();
        facts.put("model", model);

        FullCutLadderFirstRule rule = new FullCutLadderFirstRule();
        Rules rules = new Rules();
        rules.register(rule);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

        System.out.println(model.getName());
        System.out.println(model.getValue());
    }
}
