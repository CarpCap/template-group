package com.kwon.webflux.controller;

import com.kwon.webflux.dto.User;
import com.kwon.webflux.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author  CarpCap
 */
@RestController
public class HelloWebFluxController {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello, WebFlux !";
    }

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("name 1");
        user.setDesc("1111111111111111");
        return Mono.just(user);
    }


    @GetMapping("/userFlux")
    public Flux<User> getUserFlux() {

        return userService.findAll();
    }
}
