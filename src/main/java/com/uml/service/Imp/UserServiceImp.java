package com.uml.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.AdministratorMapper;
import com.uml.mapper.UserMapper;
import com.uml.pojo.Administrator;
import com.uml.pojo.Comment;
import com.uml.pojo.News;
import com.uml.pojo.User;
import com.uml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void modifyUserName(Long userId, String newUserName) {

    }

    @Override
    public void modifyUserPassword(Long userId, String newPassword) {

    }

    @Override
    public void modifyUserAge(Long userId, String newUserAge) {

    }

    @Override
    public void uploadNews(News news) {

    }

    @Override
    public void insertComment(Comment comment) {

    }

    @Override
    public void likesComment(Long commentId) {

    }

    @Override
    public List<News> getNewsByCategoryName(String categoryName) {

        return null;
    }
}
