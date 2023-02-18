package com.uml.controller;

import com.uml.mapper.*;
import com.uml.pojo.*;
import com.uml.service.AdministratorService;
import com.uml.service.CommentService;
import com.uml.service.NewsService;
import com.uml.service.UserService;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    @Value(("${web.upload-path}"))
    private String uploadPath;

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();  //获取文件原名
        String visibleUri="/"+fileName;     //拼接访问图片的地址
        String saveUri=uploadPath+"/"+fileName;        //拼接保存图片的真实地址
        System.out.println(fileName+" "+visibleUri+" "+saveUri);

        File saveFile = new File(saveUri);
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //保存文件到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }
    @PostMapping("/testFile")
    public String testFile(@RequestBody MultipartFile file){
        System.out.println(file);
        return null;
    }
    /**
     * 全局异常处理测试
     */
    @GetMapping("/error")
    public Result testError(@RequestParam Integer age) throws Exception {
        Result result = new Result();
        if(age<0){
            throw new Exception("年龄错误！！");
        }
        return result;
    }
}
