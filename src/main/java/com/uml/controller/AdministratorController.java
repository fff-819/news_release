package com.uml.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.uml.pojo.*;
import com.uml.service.*;
import com.uml.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 这里处理管理员的请求
 */
@RestController
@Api(tags = "管理员功能模块接口")
@RequestMapping("/administrators")
@CrossOrigin
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;
    @Autowired
    NewsService newsService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    /**
     * 用户登录,session的默认过期时间为30min
     */
    @ApiOperation("用户登录,session的默认过期时间为30min")
    @PostMapping("/login")
    public Result Login(@RequestParam String account, @RequestParam String password, HttpSession session){
        System.out.println("用户登录");
        System.out.println(account+password);

        Result result = new Result(false);
        Administrator administrator = administratorService.getById(Long.valueOf(account));
        if(administrator==null){
            result.setMsg("用户不存在！");
            return result;
        }else{
            if(!administrator.getPassword().equals(password)){
                result.setMsg("用户密码错误");
                return result;
            }
            result.setFlag(true);
            session.setAttribute("administrator",administrator);
            session.setMaxInactiveInterval(30*60);
        }
        return result;
    }
    /**
     * 管理员用户注册
     */
    @ApiOperation("管理员用户注册")
    @PostMapping("/register")
    public Result Register(@RequestBody Administrator administrator){
        System.out.println("用户注册");
        System.out.println(administrator);
        Result result = new Result(true);
        if(!administratorService.save(administrator)) {
            result.setFlag(false);
        }
        return result;
    }

    /**
     *新闻发布管理的功能
     */
    /**
     * 获取待审核新闻列表，查看新闻状态为1
     */
    @ApiOperation("获取待审核新闻列表")
    @GetMapping("/news/checkNews/{page}")
    public Result getCheckNews(@PathVariable Integer page){
        System.out.println("获取待审核新闻列表");

        Result result = new Result(false);
        IPage ipage = newsService.getCheckNews(page);
        if (ipage==null){
            return result;
        }
        Pages returnPage = PageUtils.myPage(ipage);
        result.setFlag(true);
        result.setData(returnPage);

        return result;
    }
    /**
     * 审核一篇新闻,
     * mp运行的代码：UPDATE news SET status=?, audit_result=? WHERE id=?
     * 实际上只需要填写主键就可以锁定要修改的数据，前端只需要将审核意见和结果、新闻id发来就行
     */
    @ApiOperation("审核一篇新闻")
    @PutMapping("/news/checkNews")
    public Result checkNews(@RequestBody News checkNews){
        System.out.println("审核一篇新闻,新闻详情："+checkNews);
        Result result = new Result(false);
        if(!newsService.updateById(checkNews)){
            result.setMsg("提交审核内容失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 删除一篇新闻
     */
    @ApiOperation("删除一篇新闻")
    @DeleteMapping("/news/{newsId}")
    public Result deleteNews(@PathVariable Long newsId){
        System.out.println("删除一篇新闻,新闻Id："+newsId);

        Result result = new Result(false);
        boolean flag = newsService.removeById(newsId);
        if (!flag){
            result.setMsg("删除id："+newsId+"的新闻失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 根据id查看新闻
     */
    @ApiOperation("根据id查看新闻")
    @GetMapping ("/news/{newsId}")
    public Result getNewsById(@PathVariable Long newsId){
        System.out.println("查看一篇新闻,新闻Id："+newsId);

        Result result = new Result(false);
        News news = newsService.getById(newsId);
        if(news==null){
            return result;
        }
        result.setFlag(true);
        result.setData(news);
        return result;
    }

    /**
     * 新闻类别管理的功能
     */
    /**
     * 获取所有新闻类别
     */
    @ApiOperation("获取所有新闻类别")
    @GetMapping("/categorys")
    public Result getAllCategory(){
        System.out.println("获取所有新闻类别");

        Result result = new Result(false);
        List<Category> categoryList = categoryService.getAllCategory();
        if(categoryList==null){
            return result;
        }
        result.setFlag(true);
        result.setData(categoryList);
        return result;
    }
    /**
     * 增加新闻类别
     */
    @ApiOperation("增加新闻类别")
    @PostMapping("/categorys")
    public Result addCategory(@RequestBody Category category){
        System.out.println("增加新闻类别");

        Result result = new Result(false);
        try {
            categoryService.save(category);
        }catch (Exception e){
            result.setMsg("新闻类别增加失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 删除新闻类别
     */
    @ApiOperation("删除新闻类别")
    @DeleteMapping ("/categorys/{categoryId}")
    public Result deleteCategory(@PathVariable Integer categoryId){
        System.out.println("删除新闻类别,id:"+categoryId);

        Result result = new Result(false);
        boolean flag = categoryService.removeById(categoryId);
        if (!flag){
            result.setMsg("删除id："+categoryId+"的新闻类别失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 修改新闻类别名称
     */
    @ApiOperation("修改新闻类别名称")
    @PutMapping("/categorys")
    public Result updateCategory(@RequestBody Category category){
        System.out.println("修改新闻类别名称");

        Result result = new Result(false);
        boolean flag = categoryService.updateById(category);
        if (!flag){
            result.setMsg("修改新闻类别失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }

    /**
     * 用户管理功能
     */
    /**
     * 增加一名用户
     */
    @ApiOperation("增加一名用户")
    @PostMapping("/users")
    public Result addUser(@RequestBody User user){
        System.out.println("增加一名用户");

        Result result = new Result(false);
        try {
            userService.save(user);
        }catch (Exception e){
            result.setMsg("增加一名用户失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 删除一名用户
     */
    @ApiOperation("删除一名用户")
    @DeleteMapping("/users/{userId}")
    public Result deleteUser(@PathVariable Long userId){
        System.out.println("删除一名用户:"+userId);

        Result result = new Result(false);
        boolean flag = userService.removeById(userId);
        if (!flag){
            result.setMsg("删除一名用户失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 修改用户信息
     */
    @ApiOperation("修改用户信息")
    @PutMapping("/users")
    public Result updateUser(@RequestBody User user){
        System.out.println("修改用户信息");

        Result result = new Result(false);
        boolean flag = userService.updateById(user);
        if (!flag){
            result.setMsg("修改用户信息失败");
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 获得所有用户信息
     */
    @ApiOperation("获得所有用户信息")
    @GetMapping("/users")
    public Result getAllUser(){
        System.out.println("获得所有用户信息");

        Result result = new Result(false);
        List<User> userList = userService.getAllUser();
        if (userList==null){
            return result;
        }
        result.setFlag(true);
        result.setData(userList);
        return result;
    }

    /**
     * 评论管理功能
     */
    /**
     * 删除一个评论
     */
    @ApiOperation("删除一个评论")
    @DeleteMapping("/comments/{commentId}")
    public Result deleteComment(@PathVariable Long commentId){
        System.out.println("删除一个评论:"+commentId);

        Result result = new Result(false);
        boolean flag = commentService.removeById(commentId);
        if (!flag){
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 获取某个新闻所有评论
     */
    @ApiOperation("获取某个新闻所有评论")
    @GetMapping("/comments/{newsId}")
    public Result getCommentByNewsId(@PathVariable Long newsId){
        System.out.println("获取某个新闻所有评论,新闻id"+newsId);
        Result result = new Result(false);
        List<Comment> commentList = commentService.getCommentByNewsId(newsId);
        result.setFlag(true);
        result.setData(commentList);
        return result;
    }

}
