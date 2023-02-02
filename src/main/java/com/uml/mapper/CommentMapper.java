package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.Administrator;
import com.uml.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 获得所有新闻评论
     * @return
     */
    @Select("select * from Comment")
    List<Comment> getAllComment();
    /**
     * 根据评论id删除评论
     */
    void deleteCommentByCommentId(Long commentId);
    /**
     * 根据新闻id获取评论
     */
    List<Comment> getCommentsByNewsId(Long newsId);
    /**
     * 根据新闻id删除所有评论
     */
    void deleteCommentsByNewsId(Long newsId);
    /**
     * 根据父评论id获取评论
     */
    List<Comment> getCommentsByParentCommentId(Long parentCommentId);
    /**
     * 根据父评论id删除所有评论
     */
    void deleteCommentsByParentCommentId(Long parentCommentId);
    /**
     * 根据用户id查询评论
     */
    List<Comment> selectCommentByUserId(Long userId);
    /**
     * 根据用户id删除所有评论
     */
    void deleteCommentsByUserId(Long userId);
}
