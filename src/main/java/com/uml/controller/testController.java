package com.uml.controller;

import com.uml.mapper.*;
import com.uml.pojo.*;
import com.uml.service.AdministratorService;
import com.uml.service.CommentService;
import com.uml.service.NewsService;
import com.uml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class testController {
    @Autowired
    AdministratorService administratorService;
    @Autowired
    CommentService commentService;
    @Autowired
    NewsService newsService;
    @Autowired
    UserService userService;

    @GetMapping("/success")
    public List success(){
        List<Administrator> allAdministrator = administratorService.getAllAdministrator();
        List<User> allUser = userService.getAllUser();
        List<Comment> allComment = commentService.getAllComment();
        List<News> allNews = newsService.getAllNews();
        System.out.println(allAdministrator);
        System.out.println(allComment);
        System.out.println(allUser);
        System.out.println(allNews);
        return allUser;
    }

    /**
     * 测试文件上传
     * @return
     */
    @PostMapping("/testFile")
    public String testFile(@RequestBody MultipartFile file){
        System.out.println(file);
        return null;
    }
}