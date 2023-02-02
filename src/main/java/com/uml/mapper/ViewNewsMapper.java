package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.ViewNews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewNewsMapper extends BaseMapper<ViewNews> {
    /**
     * 获取某个用户浏览过的新闻id
     */
    @Select("select news_id from view_news where user_id=${userId}")
    List<Long> selectViewCommentByUserId(Long userId);
}
