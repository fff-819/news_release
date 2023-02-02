package com.uml.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("浏览新闻记录类")
public class ViewNews {
    Long id;
    Long newsId;
    Long userId;
    Date createTime;

    public ViewNews() {
    }

    public ViewNews(Long newsId, Long userId) {
        this.newsId = newsId;
        this.userId = userId;
    }

    public ViewNews(Long id, Long newsId, Long userId, Date createTime) {
        this.id = id;
        this.newsId = newsId;
        this.userId = userId;
        this.createTime = createTime;
    }

    public ViewNews(Long newsId, Long userId, Date createTime) {
        this.newsId = newsId;
        this.userId = userId;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ViewNews{" +
                "id=" + id +
                ", newsId=" + newsId +
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

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
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
