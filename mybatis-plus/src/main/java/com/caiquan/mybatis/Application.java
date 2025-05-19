package com.caiquan.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2021/8/1313:58
 */
@MapperScan("com.caiquan.mybatis.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
