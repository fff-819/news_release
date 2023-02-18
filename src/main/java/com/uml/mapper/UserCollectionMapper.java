package com.uml.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uml.pojo.UserCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCollectionMapper extends BaseMapper<UserCollection> {
    /**
     * 根据用户id，获取用户收藏的新闻id
     */
    @Select("select news_id from user_collection where user_id=${userId}")
    List<Long> getAllNewsId(Long userId);
}
