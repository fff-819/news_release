package com.uml.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;
@ApiModel("新闻实体类")
public class News {
    Long id;
    Integer categoryId;
    Long administratorId;
    Long userId;
    Date createTime;
    String title;
    String content;
    Integer status;
    String auditResult;
    Integer viewTimes;

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", administratorId=" + administratorId +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", auditResult='" + auditResult + '\'' +
                ", viewTimes=" + viewTimes +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public News(Long id, Integer categoryId, Long administratorId, Date createTime, String title, String content, Integer status, String auditResult, Integer viewTimes) {
        this.id = id;
        this.categoryId = categoryId;
        this.administratorId = administratorId;
        this.createTime = createTime;
        this.title = title;
        this.content = content;
        this.status = status;
        this.auditResult = auditResult;
        this.viewTimes = viewTimes;
    }

    public News(Integer categoryId, Long userId, String title, String content) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
