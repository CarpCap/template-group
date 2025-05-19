package com.liyu.spring.controler;


import org.springframework.web.bind.annotation.*;


/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/3/2322:15
 */
@RestController
public class HelloController{

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

}
