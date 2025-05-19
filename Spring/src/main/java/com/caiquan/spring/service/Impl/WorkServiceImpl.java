package com.caiquan.spring.service.Impl;

import com.caiquan.spring.service.HelloService;
import com.caiquan.spring.service.WorkService;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/1212:37
 */
@Component
@Scope("prototype")
public class WorkServiceImpl implements WorkService {

    public WorkServiceImpl(HelloService helloService){

    }
    @Override
    public String test() {
        return "work test";
    }
}
