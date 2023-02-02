package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.Administrator;
import com.uml.pojo.Category;
import com.uml.pojo.News;

import java.util.List;

/**
 * 这里写管理员要做的事
 */
public interface AdministratorService extends IService<Administrator> {
    /**
     * 获得所有管理员信息
     * @return
     */
    List<Administrator> getAllAdministrator();
    /**
     * 管理员登录
     */
    Administrator getAdministratorById(Long userId);
    /**
     * 管理员注册
     */
    boolean insertAdministrator(Administrator administrator);
    /**
     * 查看新闻所有类别
     */
    List<Category> getAllCategory();
    /**
     * 删除新闻类别
     */
    void deleteCategory(String categoryName);
    /**
     * 修改新闻类别
     */
    void modifyCategory(String oldName,String newName);
    /**
     * 增加新闻类别
     */
    void addCategory(Category category);
    /**
     * 修改已发布新闻的新闻类别
     */
    void modifyNewsCategory(Long newsId);
    /**
     * 获取待审核新闻列表
     */
    List<News> getNotAuditNews();
    /**
     * 审核一条新闻：根据新闻id在数据库内找到新闻，修改新闻状态、审核意见,前端发起请求时应该不会传id过来，但是新闻名可能重合，还是根据id审核新闻比较合理
     */
    void auditNews(Long newsId);
    /**
     * 删除一条新闻，注意把新闻相关评论都给删了
     */
    void deleteNews(Long newsId);
    /**
     * 删除用户，仅删除用户信息
     */
    void deleteCommentsByUserId(Long userId);
    /**
     * 禁言用户
     */
    void banUser(Long userId);
    /**
     * 解除用户禁言
     */
    void releaseUser(Long userId);
    /**
     * 删除一条评论，注意要把子评论都删了
     */
    void deleteComment(Long commentId);
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
}
