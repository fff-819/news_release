package com.uml.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.CommentMapper;
import com.uml.pojo.Comment;
import com.uml.pojo.News;
import com.uml.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class CommentServiceImp extends ServiceImpl<CommentMapper,Comment> implements CommentService{
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComment() {
        List<Comment> allComment = commentMapper.getAllComment();
        return allComment;
    }

    @Override
    public List<Comment> getCommentByNewsId(Long newsId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("news_id",newsId);
        List<Comment> commentList = commentMapper.selectByMap(map);
        return commentList;
    }

    @Override
    public void descendSortCommentsByCreateTime(List<Comment> commentList) {

    }

    @Override
    public void descendSortCommentsBy(List<Comment> commentList) {

    }

    @Override
    public Comment mulGetCommentById(Long commentId) {
        return getById(commentId);
    }

    @Override
    public List<Comment> getCommentListByCommentIdList(List<Long> commentIdList) {
        List<Comment> commentList = new ArrayList<>();
        for (Long commentId : commentIdList) {
            commentList.add(mulGetCommentById(commentId));
        }
        return commentList;
    }
}
