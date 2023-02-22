package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获得所有用户信息
     * @return
     */
    @Select("select * from user")
    List<User> getAllUser();
    /**
     * 根据用户id获取用户
     */
    @Select("select * from user where user_id=${userId}")
    User getUserById(Long userId);
    /**
     * 增加一名用户
     */
    @Insert("insert into user values(${userId},#{userName},${age},#{phoneNumber},#{password},false)")
    boolean insertUser(User user);
}
