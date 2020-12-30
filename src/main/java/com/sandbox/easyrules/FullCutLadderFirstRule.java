package com.sandbox.easyrules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author zhangxin
 * @version 1.0
 * @time 2020/10/27 16:35
 */
@Rule(name = "Full Cut Ladder First", description = "Full Cut Ladder First")
public class FullCutLadderFirstRule {

    @Condition
    public boolean isBigger18(@Fact("model") RuleModel model) {
        return model.getValue() > 18;
    }

    @Action
    public void setValue19(@Fact("model") RuleModel model) {
        model.setValue(18);
    }
}
