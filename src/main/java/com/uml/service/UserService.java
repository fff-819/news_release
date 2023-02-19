package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 获得所有用户信息
     * @return
     */
    List<User> getAllUser();
    /**
     * 用户登录验证
     *
     */
    Result loginCheck(User user ,HttpServletResponse response);
    /**
     * 根据姓名查询用户
     */
    User getUserByName(String userName);

}
