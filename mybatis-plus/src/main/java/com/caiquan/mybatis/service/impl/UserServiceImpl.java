package com.caiquan.mybatis.service.impl;

import com.caiquan.mybatis.entity.User;
import com.caiquan.mybatis.mapper.UserMapper;
import com.caiquan.mybatis.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author  CarpCap
 * @since 2021-08-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
