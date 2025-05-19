package com.caiquan.hello.feign.fallback;

import com.caiquan.hello.feign.HelloFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/2817:40
 */
@Component
@RequestMapping("")
public class HelloFeignFallback implements HelloFeign {
    @Override
    public String hello() throws Exception {
        return "error world";
    }
}
