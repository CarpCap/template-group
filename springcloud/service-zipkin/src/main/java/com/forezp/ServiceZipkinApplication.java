package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @ClassName ServiceZipkinApplication
 * @Auther: CarpCap
 * @Date: 2019-11-25 04:24
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ServiceZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinApplication.class,args);

    }
}
