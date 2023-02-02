package com.uml.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.LikeCommentMapper;
import com.uml.pojo.LikeComment;
import com.uml.service.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeCommentServiceImp extends ServiceImpl<LikeCommentMapper, LikeComment> implements LikeCommentService {
    @Autowired
    LikeCommentMapper likeCommentMapper;
    @Override
    public List<Long> getLikeComment(Long newsId, Long userId) {
        return likeCommentMapper.SelectLikeComment(newsId,userId);
    }

    @Override
    public Boolean insertCommentLikes(LikeComment likeComment) {
        return likeCommentMapper.insert(likeComment)>0?true:false;
    }

    @Override
    public Boolean deleteCommentLikes(Long commentId,Long userId) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("comment_id",commentId);
        wrapper.eq("user_id",userId);
        return likeCommentMapper.delete(wrapper)>0?true:false;
    }

    @Override
    public List<Long> getlikeCommentByUserId(Long userId) {

        return likeCommentMapper.selectlikeCommentByUserId(userId);
    }
}
