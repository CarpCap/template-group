package com.caiquan.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caiquan.mybatis.entity.User;
import com.caiquan.mybatis.mapper.UserMapper;
import com.caiquan.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2021/8/1314:07
 */
@SpringBootTest

public class MybatisTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void foreachUser(){
        System.out.println("select all user info ");
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);


}


    @Test
    public void testUpdate() {
        User user = userMapper.selectById(1);
        user.setName("tom2").setAge(213).setEmail("1313@163.com");
        userService.updateById(user);
    }

    @Test
    public void testPage() {
        // Step1：创建一个 Page 对象
        Page<User> page = new Page<>();
        // Page<User> page = new Page<>(2, 5);
        // Step2：调用 mybatis-plus 提供的分页查询方法
        userService.page(page, null);
        // Step3：获取分页数据
        System.out.println(page.getCurrent()); // 获取当前页
        System.out.println(page.getTotal()); // 获取总记录数
        System.out.println(page.getSize()); // 获取每页的条数
        System.out.println(page.getRecords()); // 获取每页数据的集合
        System.out.println(page.getPages()); // 获取总页数
        System.out.println(page.hasNext()); // 是否存在下一页
        System.out.println(page.hasPrevious()); // 是否存在上一页
    }

    @Test
    public void testPage2(){
        Page<User> userIPage=new Page<>(1,2);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",1);
        //分页查询
        Page<User> userIPage1 = userMapper.selectPage(userIPage, queryWrapper);
        // Step3：获取分页数据
        System.out.println(userIPage.getCurrent()); // 获取当前页
        System.out.println(userIPage.getTotal()); // 获取总记录数
        System.out.println(userIPage.getSize()); // 获取每页的条数
        System.out.println(userIPage.getRecords()); // 获取每页数据的集合
        System.out.println(userIPage.getPages()); // 获取总页数
        System.out.println(userIPage.hasNext()); // 是否存在下一页
        System.out.println(userIPage.hasPrevious()); // 是否存在上一页
        userIPage1.getRecords().forEach(System.out::println);
    }

    @Test
    public void testFind(){
        List<User> users = userMapper.selectByAge(21);
        users.forEach(System.out::println);
    }

}
