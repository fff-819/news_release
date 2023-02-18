package com.uml.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;
@ApiModel("用户收藏记录表")
public class UserCollection {
    Long id;
    Long userId;
    Long newsId;
    Date createTime;

    public UserCollection() {
    }

    public UserCollection(Long userId, Long newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", userId=" + userId +
                ", newsId=" + newsId +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
