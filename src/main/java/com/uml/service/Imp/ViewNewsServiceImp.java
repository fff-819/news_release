package com.uml.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.ViewNewsMapper;
import com.uml.pojo.ViewNews;
import com.uml.service.ViewNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewNewsServiceImp extends ServiceImpl<ViewNewsMapper, ViewNews> implements ViewNewsService {
    @Autowired
    ViewNewsMapper viewNewsMapper;
    @Override
    public Boolean insertViewNews(ViewNews viewNews) {
        return save(viewNews);
    }

    @Override
    public List<Long> getViewCommentByUserId(Long userId) {
        return viewNewsMapper.selectViewCommentByUserId(userId);
    }
}
