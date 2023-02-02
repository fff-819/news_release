package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.ViewNews;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * 浏览记录服务类
 */
public interface ViewNewsService extends IService<ViewNews> {
    /**
     * 多线程插入浏览记录
     * @param viewNews
     * @return
     */
    @Async("myExecutor")
    public Boolean insertViewNews(ViewNews viewNews);
    /**
     * 根据用户id获得该用户浏览过的文章
     */
    public List<Long> getViewCommentByUserId(Long userId);
}
