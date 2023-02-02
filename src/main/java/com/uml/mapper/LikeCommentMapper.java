package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.LikeComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LikeCommentMapper extends BaseMapper<LikeComment> {
    /**
     * 根据新闻id和用户id查询该用户对于某个新闻下点赞的评论列表
     */
    @Select("select comment_id from like_comment where news_id=${newsId} and user_id=${userId}")
    public List<Long> SelectLikeComment(Long newsId,Long userId);
    /**
     * 根据用户id获取评论id列表
     */
    @Select("select comment_id from like_comment where user_id=${userId}")
    List<Long> selectlikeCommentByUserId(Long userId);
}
