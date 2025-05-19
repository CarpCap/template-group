package com.caiquan.hello.controller.impl;

import com.caiquan.hello.controller.HelloController;
import com.caiquan.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@RestController
public class HelloControllerImpl implements HelloController {
    @Autowired
    HelloService helloServiceImpl;

    @Override
    public String hello() throws InterruptedException {
        System.out.printf("收到一次请求 哈哈");
        return helloServiceImpl.hello();
    }

}
