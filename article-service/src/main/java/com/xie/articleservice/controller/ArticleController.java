package com.xie.articleservice.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.xie.articleservice.dto.ResponseObject;
import com.xie.articleservice.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 如果是VIP会员,可以查看所有普通文章与精选文章
     * 如果是普通会员,只能查看所有普通文章
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseObject list() {
        return new ResponseObject("0", "success", articleService.list());
    }

    @GetMapping("/rule_setting")
    public String initFlowRule() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("/list");
        //来源设置为默认所有default
        rule.setLimitApp("default");
        // 阈值类型
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 流控模式
        rule.setStrategy(RuleConstant.STRATEGY_DIRECT);
        //单机阈值, 限制为QPS 为100
        rule.setCount(100);
        //流控效果设置为"预热"
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP);
        //预热时间20秒
        rule.setWarmUpPeriodSec(20);
        rules.add(rule);
        //设置,FlowRuleManager是Sentinel规则管理器
        FlowRuleManager.loadRules(rules);
        return "SUCCESS";
    }

}
