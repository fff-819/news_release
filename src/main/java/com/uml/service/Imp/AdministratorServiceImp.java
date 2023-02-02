package com.uml.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uml.mapper.AdministratorMapper;
import com.uml.pojo.Administrator;
import com.uml.pojo.Category;
import com.uml.pojo.News;
import com.uml.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministratorServiceImp extends ServiceImpl<AdministratorMapper,Administrator> implements AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    @Override
    public List<Administrator> getAllAdministrator() {
        return administratorMapper.selectList(null);
    }

    @Override
    public Administrator getAdministratorById(Long userId) {
        return null;
    }

    @Override
    public boolean insertAdministrator(Administrator administrator) {
        return false;
    }

    @Override
    public List<Category> getAllCategory() {
        return null;
    }

    @Override
    public void deleteCategory(String categoryName) {

    }

    @Override
    public void modifyCategory(String oldName, String newName) {

    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void modifyNewsCategory(Long newsId) {

    }

    @Override
    public List<News> getNotAuditNews() {
        return null;
    }

    @Override
    public void auditNews(Long newsId) {

    }

    @Override
    public void deleteNews(Long newsId) {

    }

    @Override
    public void deleteCommentsByUserId(Long userId) {

    }

    @Override
    public void banUser(Long userId) {

    }

    @Override
    public void releaseUser(Long userId) {

    }

    @Override
    public void deleteComment(Long commentId) {

    }

    @Override
    public void modifyUserName(Long userId, String newUserName) {

    }

    @Override
    public void modifyUserPassword(Long userId, String newPassword) {

    }

    @Override
    public void modifyUserAge(Long userId, String newUserAge) {

    }
}
