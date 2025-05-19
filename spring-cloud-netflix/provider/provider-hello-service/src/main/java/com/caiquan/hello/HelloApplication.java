package com.caiquan.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/10/2816:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);
    }
}
