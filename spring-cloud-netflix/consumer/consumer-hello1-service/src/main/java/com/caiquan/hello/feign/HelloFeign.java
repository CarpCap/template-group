package com.caiquan.hello.feign;

import com.caiquan.hello.controller.HelloController;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/2817:30
 */
@FeignClient(name = "hello-service")
public interface HelloFeign extends HelloController {
}
