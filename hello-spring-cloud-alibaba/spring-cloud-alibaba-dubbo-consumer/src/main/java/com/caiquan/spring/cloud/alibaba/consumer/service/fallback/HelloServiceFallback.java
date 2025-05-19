package com.caiquan.spring.cloud.alibaba.consumer.service.fallback;

import com.caiquan.spring.cloud.alibaba.consumer.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloServiceFallback
 * @Auther: CarpCap
 * @Date: 2020-01-05 22:50
 * @Description:
 */
@Component
public class HelloServiceFallback implements HelloService {

    public String hello(){
        return "降级fallback";
    };
}
