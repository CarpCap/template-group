package com.caiquan.spring.cloud.alibaba.consumer.controller;

import com.caiquan.spring.cloud.alibaba.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConsummerController
 * @Auther: CarpCap
 * @Date: 2020-01-02 02:15
 * @Description:
 */
@RestController
public class ConsummerController {
    @Autowired
    HelloService helloService;
    @GetMapping("/chello/{name}")
    public String chello(@PathVariable("name") String name){

        return helloService.hello()+name;
    }

}
