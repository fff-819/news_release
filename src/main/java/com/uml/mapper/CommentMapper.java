package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.Administrator;
import com.uml.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 获得所有新闻评论
     * @return
     */
    @Select("select * from Comment")
    List<Comment> getAllComment();
}
