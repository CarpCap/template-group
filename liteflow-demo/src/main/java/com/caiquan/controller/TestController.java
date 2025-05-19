package com.caiquan.controller;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author  CarpCap
 */
@RestController
public class TestController {

    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping("test")
    public String test() {
        //每一次都加载规则 热刷新
        flowExecutor.reloadRule();
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
        flowExecutor.reloadRule();
        return "success";
    }
}
