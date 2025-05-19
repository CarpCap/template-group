package com.kwon;

import com.tencent.cloud.polaris.PolarisDiscoveryProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  CarpCap
 */
@SpringBootApplication
public class SpringCloudProviderApplication {

    @RestController
    static class EchoController {

        private final PolarisDiscoveryProperties properties;

        EchoController(PolarisDiscoveryProperties properties) {
            this.properties = properties;
        }

        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return "Hello PolarisMesh " + string + ", I'm " + properties.getService();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApplication.class, args);
    }
}