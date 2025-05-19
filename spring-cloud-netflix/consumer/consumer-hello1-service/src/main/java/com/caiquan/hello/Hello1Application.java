package com.caiquan.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/2817:26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Hello1Application {
    public static void main(String[] args) {
        SpringApplication.run(Hello1Application.class,args);
    }
}
