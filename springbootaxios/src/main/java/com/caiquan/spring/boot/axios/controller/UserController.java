package com.caiquan.spring.boot.axios.controller;

import com.caiquan.spring.boot.axios.domain.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Auther: CarpCap
 * @Date: 2020-01-11 16:01
 * @Description:
 */
@CrossOrigin("*")
@RestController
public class UserController {
    @GetMapping("/user")
    public User user(){
        User user=new User();
        user.setName("灶门米豆子");
        return user;
    }
}
