package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.Administrator;
import com.uml.pojo.Comment;
import com.uml.pojo.News;
import com.uml.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 获得所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 修改用户名
     */
    void modifyUserName(Long userId,String newUserName);
    /**
     * 修改密码
     */
    void modifyUserPassword(Long userId,String newPassword);
    /**
     * 修改年龄
     */
    void modifyUserAge(Long userId,String newUserAge);
    /**
     * 用户上传新闻，上传新闻前检查新闻是否已经，因为存在新闻被审核之后打回的情况。
     */
    void uploadNews(News news);
    /**
     * 发布一条评论
     */
    void insertComment(Comment comment);
    /**
     * 给评论点赞
     */
    void likesComment(Long commentId);
    /**
     * 根据新闻分类浏览新闻
     */
    List<News> getNewsByCategoryName(String categoryName);
}
