package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.Administrator;
import com.uml.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface NewsMapper extends BaseMapper<News> {
    /**
     * 获得所有新闻
     * @return
     */
    @Select("select * from News")
    List<News> getAllNews();
    /**
     * 增加一条新闻
     */
    void insertNews(News news);
    /**
     * 根据新闻分类名和页数获取新闻列表
     */

    List<News> getNewsByCategoryName(String categoryName);
    /**
     * 根据新闻标题获取新闻列表（支持模糊查询）
     */
    List<News> getNewsByTitle(String title);
    /**
     * 根据新闻id获取新闻信息
     */
    News getNewsByNewsId(Long newsId);
    /**
     * 根据新闻状态获取新闻列表,用于管理员获取待审核新闻
     */
    List<News> getNewsByStatus(Integer status);
    /**
     * 根据新闻id修改新闻状态
     */
    void modifyNewsByNewsId(Long newsId);
}
