package com.uml.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;
@ApiModel("评论实体类")
public class Comment {
    Long id;
    Long userId;
    Long newsId;
    Long parentId;
    String content;
    Date createTime;
    Integer likes;
    //用于标记该用户是否已经给该评论点赞，true代表点赞，false代表未点赞。
    Boolean flag=false;

    public Comment(Long id, Boolean flag) {
        this.id = id;
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", newsId=" + newsId +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", likes=" + likes +
                ", flag=" + flag +
                '}';
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Comment() {
    }

    public Comment(Long id, Long userId, Long newsId, Long parentId, String content, Date createTime, Integer likes) {
        this.id = id;
        this.userId = userId;
        this.newsId = newsId;
        this.parentId = parentId;
        this.content = content;
        this.createTime = createTime;
        this.likes = likes;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
