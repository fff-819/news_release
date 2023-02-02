package com.uml.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;
@ApiModel("点赞记录类")
public class LikeComment {
    Long id;
    Long commentId;
    Long userId;
    Date createTime;

    public LikeComment() {
    }
    public LikeComment(Long id, Long commentId, Long userId) {
        this.id = id;
        this.commentId = commentId;
        this.userId = userId;
    }

    public LikeComment(Long commentId, Long userId) {
        this.commentId = commentId;
        this.userId = userId;
    }

    public LikeComment(Long id, Long commentId, Long userId, Date createTime) {
        this.id = id;
        this.commentId = commentId;
        this.userId = userId;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LikeComment{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
