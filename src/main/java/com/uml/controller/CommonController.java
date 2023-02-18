package com.uml.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Api(tags = "工具接口")
public class CommonController {
    @Value(("${web.upload-path}"))
    private String uploadPath;
    /**
     * 图片上传的接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload/{userId}")
    public String upload(@RequestPart("file") MultipartFile file, @PathVariable Long userId) throws IOException {
        String fileName = file.getOriginalFilename();  //获取文件原名
        String userPath = userId.toString();    //用户id
        String visibleUri="/"+fileName;     //拼接访问图片的地址
        String saveUri=uploadPath+"\\"+userPath+"\\"+fileName;        //拼接保存图片的真实地址
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
}
