package com.caiquan.hello.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  CarpCap
 * @Title: controller interface
 * @Description: 将controller定义出一个接口，这个接口可以方便spring cloud netflix feign来调用
 * @date 2020/10/2814:38
 */
@RequestMapping("hello")
public interface HelloController {
    @PostMapping("world")
    String hello() throws Exception;
}
