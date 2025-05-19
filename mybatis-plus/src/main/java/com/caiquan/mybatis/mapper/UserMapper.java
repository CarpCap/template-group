package com.caiquan.mybatis.mapper;

import com.caiquan.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author  CarpCap
 * @since 2021-08-13
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where age = #{age}")
    public List<User> selectByAge(int age);


    @Update("update user set age=#{age} where id= #{id}")
    boolean updateAgeById(int id, int age);
}
