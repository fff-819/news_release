package com.uml.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.AdministratorMapper;
import com.uml.mapper.UserMapper;
import com.uml.pojo.*;
import com.uml.service.UserService;
import com.uml.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.sql.Wrapper;
import java.util.List;
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenUtil tokenUtil;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public Result loginCheck(Long account, String password,HttpServletResponse response){
        User user = userMapper.selectById(account);
        if(user == null ){
            //response.sendRedirect("/login");
            return new Result(false,null,"用户不存在") ;
        }
        if(!user.getPassword().equals(password)){
            return new Result(false,null,"密码输入错误");
        }
        String token = tokenUtil.generateToken(user) ;
        System.out.println("token:" + token);
        Cookie cookie = new Cookie("token" , token) ;
        // 设置cookie的作用域：为”/“时，以在webapp文件夹下的所有应用共享cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        System.out.println("cookie:"+cookie);
        return new Result(true,token,"用户登录成功");
    }

    @Override
    public User getUserByName(String userName) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",userName);
        User user = userMapper.selectOne(wrapper);
        return user;
    }


}
