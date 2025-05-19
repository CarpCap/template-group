package com.caiquan.mybatis.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.caiquan.mybatis.entity.User;
import com.caiquan.mybatis.mapper.UserMapper;
import com.caiquan.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author  CarpCap
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @PostMapping("age/{id}/{age}")
    public boolean saveAgeById(@PathVariable("id") Long id, @PathVariable("age") Integer age) {

        final UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.set("age",age);
        User user = new User();
        user.setId(id);
        return userService.update(user,userUpdateWrapper);
    }

    @GetMapping
    public User find(@PathVariable("id") Integer id) throws InterruptedException {
        System.out.println(userService.getById(id).getName());
        Thread.sleep(10000);
        System.out.println(userService.getById(id).getName());
        return userService.getById(id);
    }

    @GetMapping("s")
    @Transactional
    public List<User> finds() throws InterruptedException {
        System.out.println(userService.getBaseMapper().selectList(null));
        System.out.println(userService.getBaseMapper().selectList(null));
        return userService.getBaseMapper().selectList(null);
    }
}

