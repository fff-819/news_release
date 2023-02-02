package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.LikeComment;
import com.uml.pojo.ViewNews;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * 点赞记录服务类
 */
public interface LikeCommentService extends IService<LikeComment> {
    /**
     * 根据新闻id和用户id查询该用户对于某个新闻下点赞的评论列表
     */
    public List<Long> getLikeComment(Long newsId, Long userId);

    /**
     * 插入一条点赞记录
     * @param likeComment
     * @return
     */
    @Async("myExecutor")
    public Boolean insertCommentLikes(LikeComment likeComment);
    /**
     * 删除一条点赞记录
     */
    @Async("myExecutor")
    public Boolean deleteCommentLikes(Long commentId,Long userId);
    /**
     * 根据用户id获取该用户点赞过的评论id列表
     */
    List<Long> getlikeCommentByUserId(Long userId);
}
