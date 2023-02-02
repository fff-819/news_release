package com.uml.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.Administrator;
import com.uml.pojo.News;
import org.apache.ibatis.annotations.Select;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface NewsService extends IService<News> {
    /**
     * 获得所有新闻
     */
    List<News> getAllNews();

    /**
     * 获取待审核新闻列表
     */
    IPage getCheckNews(Integer page);
    /**
     * 将新闻按查看次数降序排序
     */
    void descendSortNewsByViewTimes(List<News> newsList);
    /**
     * 将新闻按查看次数升序排序
     */
    void ascendSortNewsByViewTimes(List<News> newsList);
    /**
     * 按新闻类别和页数获取新闻信息
     */
    IPage getNewsByCategoryAndPage(String CategoryName, Integer page);
    /**
     * 根据新闻id列表获取新闻列表
     */
    List<News> getNewsByNewsIdList(List<Long> newsIdList);
    /**
     * 多线程根据新闻id获取新闻。
     */
    @Async
    News mulGetNewsById(Long newsId);
}
