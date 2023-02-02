package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.Administrator;
import com.uml.pojo.Comment;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface CommentService extends IService<Comment> {
    /**
     * 获取所有评论
     */
    List<Comment> getAllComment();
    /**
     * 获取某个新闻下的所有评论
     */
    List<Comment> getCommentByNewsId(Long newsId);
    /**
     * 将评论列表按评论时间降序排序
     */
    void descendSortCommentsByCreateTime(List<Comment> commentList);
    /**
     * 将评论列表按点赞数量降序排序
     */
    void descendSortCommentsBy(List<Comment> commentList);
    /**
     * 多线程根据评论id获取评论
     */
    @Async
    public Comment mulGetCommentById(Long commentId);
    /**
     * 根据评论id列表获取评论列表
     */
    public List<Comment> getCommentListByCommentIdList(List<Long> commentIdList);
}
