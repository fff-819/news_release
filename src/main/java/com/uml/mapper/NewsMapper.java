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
}
