package com.caiquan.hello.feign;


import com.caiquan.hello.controller.HelloController;
import com.caiquan.hello.feign.fallback.HelloFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/2817:30
 */
@FeignClient(value = "hello-service",fallback = HelloFeignFallback.class)
public interface HelloFeign  extends HelloController {

}
