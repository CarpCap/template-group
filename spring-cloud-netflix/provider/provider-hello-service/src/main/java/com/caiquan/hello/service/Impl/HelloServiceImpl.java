package com.caiquan.hello.service.Impl;


import com.caiquan.hello.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/3/2322:27
 */
@Component

public class HelloServiceImpl implements HelloService {

    @Override
    public String hello() {
        return "hello world";
    }
}
