package com.uml.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.UserCollectionMapper;
import com.uml.pojo.UserCollection;
import com.uml.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectionServiceImp extends ServiceImpl<UserCollectionMapper, UserCollection> implements UserCollectionService {
   @Autowired
   UserCollectionMapper userCollectionMapper;
    @Override
    public Boolean notCollect(Long userId, Long newsId) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("news_id",newsId);
        int delete = userCollectionMapper.delete(wrapper);
        return delete>0?true:false;
    }

    @Override
    public Boolean selectCollectByUserIdAndNewsId(Long userId, Long newsId) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("news_id",newsId);
        UserCollection userCollection = userCollectionMapper.selectOne(wrapper);
        if(userCollection==null){
            return false;
        }
        return true;
    }
    @Override
    public List<Long> getNewsIdListByUserId(Long userId) {
        return userCollectionMapper.getAllNewsId(userId);
    }
}
