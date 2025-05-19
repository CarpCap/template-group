package com.kwon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author  CarpCap
 */
@SpringBootApplication
public class SpringCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    class EchoController {

        private final RestTemplate template;

        EchoController(RestTemplate template) {
            this.template = template;
        }

        @RequestMapping(value = "/echo", method = RequestMethod.GET)
        public String echo(@RequestParam(name = "value") String val) {
            return template.getForObject("http://EchoServer/echo/" + val, String.class);
        }
    }

    @FeignClient(name = "EchoServer")
    public interface Echo1ServerClient {

        @GetMapping("/echo/{value}")
        String echo(@PathVariable("value") String value);
    }

//
//    @RestController
//    static class EchoController {
//
//        private final EchoServerClient client;
//
//        EchoController(EchoServerClient client) {
//            this.client = client;
//        }
//
//        @GetMapping(value = "/echo")
//        public String echo(@RequestParam(name = "value") String val) {
//            return client.echo(val);
//        }
//    }
//
//    @FeignClient(name = "EchoServer")
//    public interface EchoServerClient {
//
//        @GetMapping("/echo/{value}")
//        String echo(@PathVariable("value") String value);
//    }
}
