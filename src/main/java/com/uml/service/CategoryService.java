package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.Category;
import com.uml.pojo.News;

import java.util.List;

public interface CategoryService extends IService<Category> {
    List<Category> getAllCategory();
}
