package com.caiquan.spring.service.Impl;

import com.caiquan.spring.service.HelloService;
import com.caiquan.spring.service.WorkService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.Transient;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/3/2322:27
 */
@Component
@Scope("prototype")
public class HelloServiceImpl implements HelloService {
    public int vue=1;

//    public HelloServiceImpl(WorkService workService) { }


    public HelloServiceImpl(){
        System.out.println("测试Bean的初始化时机");
    }

    @Override
    @Transient
    public String hello() {
        return "str"+(vue++);
    }
}
