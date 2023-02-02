package com.uml.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.CategoryMapper;
import com.uml.mapper.NewsMapper;
import com.uml.pojo.Category;
import com.uml.pojo.News;
import com.uml.service.CategoryService;
import com.uml.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class CategoryServiceImp extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectList(null);
    }
}
