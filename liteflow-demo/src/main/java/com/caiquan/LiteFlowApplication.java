package com.caiquan;

import com.caiquan.component.YourClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author  CarpCap
 */
@SpringBootApplication
public class LiteFlowApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LiteFlowApplication.class, args);
        YourClass yourClass = run.getBean("yourClass", YourClass.class);
        yourClass.testConfig();
    }
}