package com.cckeep.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author jixd
 * @Date Created in 2019年02月26日 10:14
 */
public class BooleanTest {
    public static void main(String[] args) {
// 配置规则.
        initFlowRules();
        while (true){
            if (SphO.entry("HelloWorld")){
                try {
                    System.out.println("hello world");
                } finally {
                    SphO.exit();
                }
            }else{
                System.out.println("out");
            }


    }
    }
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
