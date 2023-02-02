package com.uml.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.CategoryMapper;
import com.uml.mapper.NewsMapper;
import com.uml.pojo.Category;
import com.uml.pojo.News;
import com.uml.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImp extends ServiceImpl<NewsMapper,News> implements NewsService {
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<News> getAllNews() {
        return newsMapper.getAllNews();
    }

    @Override
    public IPage getCheckNews(Integer page) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("status",1);
        //设置了每一页的新闻条数为5
        IPage pages = new Page(page,5);
        page(pages, wrapper);
        return pages;
    }

    @Override
    public void descendSortNewsByViewTimes(List<News> newsList) {

    }

    @Override
    public void ascendSortNewsByViewTimes(List<News> newsList) {

    }

    @Override
    public IPage getNewsByCategoryAndPage(String CategoryName, Integer page) {
        //获取新闻分类对应的id
        HashMap<String, Object> map = new HashMap<>();
        map.put("category_name",CategoryName);
        List<Category> categories = categoryMapper.selectByMap(map);
        if(categories==null){
            return null;
        }
        Integer categoryId = categories.get(0).getId();

        //根据新闻分类id和页数获取已发布新闻
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",categoryId);
        wrapper.eq("status",2);
        //设置了每一页的新闻条数为5
        IPage pages = new Page(page,5);
        page(pages, wrapper);
        return pages;
    }

    @Override
    public List<News> getNewsByNewsIdList(List<Long> newsIdList) {
        List<News> newsList = new ArrayList<>();
        for (Long newsId : newsIdList) {
            newsList.add(mulGetNewsById(newsId));
        }
        return newsList;
    }

    @Override
    public News mulGetNewsById(Long newsId) {
        return getById(newsId);
    }


}
