package com.uml.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.uml.mapper.CategoryMapper;
import com.uml.pojo.*;
import com.uml.service.*;
import com.uml.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * 这里处理用户的请求
 */
@RestController
@Api(tags = "用户功能模块接口")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    NewsService newsService;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeCommentService likeCommentService;
    @Autowired
    ViewNewsService viewNewsService;
    @Autowired
    UserCollectionService userCollectionService;
    /**
     * 用户登录,session的默认过期时间为30min
     */
    @ApiOperation("用户登录,session的默认过期时间为30min")
    @PostMapping("/login")
    public Result Login(@RequestParam String account,@RequestParam String password,HttpSession session){
        System.out.println("用户登录");
        System.out.println("account:"+account+"  password:"+password);

        Result result = new Result(false);
        User user = userService.getById(Long.valueOf(account));
        System.out.println(user);
        if(user==null){
            result.setMsg("用户不存在！");
            return result;
        }else{
            if(!user.getPassword().equals(password)){
                result.setMsg("用户密码错误");
                return result;
            }
            result.setFlag(true);
            session.setAttribute("user",user);
            session.setMaxInactiveInterval(30*60);
        }
        return result;
    }
    /**
     * 用户注册:注册时要求输入id、姓名、年龄、密码、电话
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result Register(@RequestBody User user){
        System.out.println("用户注册");
        System.out.println(user);
        Result result = new Result(true);
        if(!userService.save(user)) {
            result.setFlag(false);
        }
        return result;
    }
    /**
     * 用户收藏新闻
     */
    @ApiOperation("用户收藏新闻：收藏过的话会自动取消，没收藏过的收藏")
    @PostMapping("collection/{userId}/{newsId}")
    public Result collectNews(@PathVariable Long userId,@PathVariable Long newsId){
        System.out.println("用户收藏新闻");
        System.out.println(userId+newsId);
        Result result = new Result(true);
        boolean flag;
        Boolean f = userCollectionService.selectCollectByUserIdAndNewsId(userId, newsId);
        if (!f){
            flag = userCollectionService.save(new UserCollection(userId, newsId));
        }else{
            flag = userCollectionService.notCollect(userId,newsId);
        }
        result.setFlag(flag);
        return result;
    }
    /**
     * 搜索新闻
     */
    @ApiOperation("搜索新闻")
    @GetMapping("/search/{title}/{userId}")
    public Result searchNews(@PathVariable String title,@PathVariable Long userId){
        System.out.println("搜索新闻");
        System.out.println("title："+title+",userid:"+userId);
        Result result = new Result();
        List<News> newsList = newsService.searchNewsByTitle(title);
        System.out.println(newsList);
        result.setFlag(true);
        result.setData(newsList);
        return result;
    }
    /**
     * 用户按分类浏览信息,同时附上分页信息,这里直接设置了页面内包含的新闻条数
     */
    @ApiOperation("用户按分类浏览信息,同时附上分页信息,这里直接设置了页面内包含的新闻条数")
    @GetMapping("news/{categoryName}/{page}")
    public Result scanNewsBynewsName(@PathVariable String categoryName,@PathVariable Integer page){
        System.out.println("category:"+categoryName+" ,page:"+page);

        Result result = new Result();
        //构造新闻列表
        IPage pages = null;
        try {
            pages = newsService.getNewsByCategoryAndPage(categoryName,page);
        } catch (Exception e) {
            result.setFlag(false);
            return result;
        }
        Pages returnPage = PageUtils.myPage(pages);
        result.setFlag(true);
        result.setData(returnPage);
        return result;
    }
    /**
     * 查看某个新闻详情
     */
    @ApiOperation("查看某个新闻详情")
    @GetMapping("news")
    public Result getNewsById(@RequestParam Long userId,@RequestParam Long newsId){
        System.out.println("查看某个新闻详情");
        System.out.println("用户id："+userId);
        System.out.println("newsId:"+newsId);
        Result result = new Result(false);
        viewNewsService.insertViewNews(new ViewNews(userId, newsId));
        News news = newsService.getById(newsId);
        if (news==null){
            return result;
        }
        System.out.println(news);
        result.setFlag(true);
        result.setData(news);
        return result;
    }
    /**
     * 发表新闻，参数：新闻分类、作者id、标题、内容。
     */
    @ApiOperation("发表新闻")
    @PostMapping("/news")
    /*public Result updateNews(@RequestParam Long userId,@RequestParam Integer categoryId,@RequestParam String title,@RequestParam String context){
        System.out.println("发表新闻"+context);

        Result result = new Result();
        News news = new News(categoryId,userId,title,context);
        boolean flag = newsService.save(news);
        if (!flag){
            result.setFlag(false);
            return result;
        }
        result.setFlag(true);
        return result;
    }*/
    public Result updateNews(@RequestBody News news){
        System.out.println("发表新闻"+news);
        Result result = new Result();
        boolean flag = newsService.save(news);
        if (!flag){
            result.setFlag(false);
            return result;
        }
        result.setFlag(true);
        return result;
    }
    /**
     * 发布评论,参数：新闻id，用户id，父评论id，评论内容
     */
    @ApiOperation("发布评论")
    @PostMapping("/news/comments")
    public Result releaseComment(@RequestBody Comment comment){
        System.out.println(comment);
        System.out.println("发布评论");
        Result result = new Result();
        boolean flag = commentService.save(comment);
        result.setFlag(flag);
        return result;
    }
    /**
     * 查看某个新闻的所有评论
     */
    @ApiOperation("查看某个新闻的所有评论")
    @GetMapping("/news/comments/{userId}/{newsId}")
    public Result viewComments(@PathVariable Long userId,@PathVariable Long newsId){
        System.out.println("newsId:"+newsId);
        System.out.println("获得评论");
        Result result = new Result();
        //获取新闻评论列表
        List<Comment> commentList = commentService.getCommentByNewsId(newsId);
        //获取该用户在该新闻下点赞过的评论列表id
        List<Long> likeCommentIdList = likeCommentService.getLikeComment(newsId, userId);
        if (likeCommentIdList!=null){
            for (Comment comment : commentList) {
                for (int i = 0; i < likeCommentIdList.size(); i++) {
                    if(comment.getId().equals(likeCommentIdList.get(i))){
                        comment.setFlag(true);
                    }
                }
            }
        }
        if (commentList==null){
            result.setFlag(false);
            return result;
        }
        result.setFlag(true);
        result.setData(commentList);
        return result;
    }
    /**
     * 评论点赞,这里应该检查一下该用户是否已经给该评论点赞,这里的参数：评论id，flag是必须的其他的可以不用,点赞人id
     * flag是该点赞人是否已经给评论点赞，在获取评论列表的过程中该值已被设置。
     */
    @ApiOperation("评论点赞")
    @PutMapping("/news/comments")
    public Result likesComment(@RequestParam Long commentId,@RequestParam Boolean flag,@RequestParam Long userId){
        System.out.println("点赞评论");
        System.out.println("commentId:"+commentId+",flag:"+flag);
        System.out.println("userId:"+userId);
        Result result = new Result();
        Comment comment = commentService.getById(commentId);
        if (flag){
            comment.setLikes(comment.getLikes()-1);
            likeCommentService.deleteCommentLikes(comment.getId(),userId);
        }else {
            comment.setLikes(comment.getLikes()+1);
            likeCommentService.insertCommentLikes(new LikeComment(comment.getId(),userId));
        }
        //这里要设置点赞标志默认为false
        comment.setFlag(false);
        result.setFlag(commentService.updateById(comment));
        return result;
    }

    /**
     * 用户个人中心模块:personal
     */
    /**
     * 查看个人信息
     */
    @ApiOperation("查看个人信息")
    @GetMapping("/personal/{userId}")
    public Result viewPersonal(@PathVariable Long userId){
        System.out.println("userId:"+userId);
        System.out.println("查看个人信息");
        Result result = new Result();
        User user = userService.getById(userId);
        if (user==null){
            result.setFlag(false);
            return result;
        }
        result.setFlag(true);
        result.setData(user);
        return result;
    }
    /**
     * 修改个人信息
     */
    @ApiOperation("修改个人信息")
    @PutMapping("/personal")
    public Result modifyPersonal(@RequestBody User user){
        System.out.println("user:"+user);
        System.out.println("修改个人信息");
        Result result = new Result();
        boolean flag = userService.updateById(user);
        if (flag){
            result.setFlag(false);
        }else {
            result.setFlag(true);
        }
        return result;
    }
    /**
     * 查看浏览过的文章
     */
    @ApiOperation("查看浏览过的文章")
    @GetMapping("/personal/news/{userId}}")
    public Result viewBrowsedNews(@PathVariable Long userId){
        System.out.println("userId:"+userId);
        System.out.println("查看浏览过的文章");
        Result result = new Result();
        List<News> newsList;
        try {
            //获取浏览过给新闻id
            List<Long> newsIdList = viewNewsService.getViewCommentByUserId(userId);
            //根据新闻id列表获取新闻列表
            newsList = newsService.getNewsByNewsIdList(newsIdList);
        }catch (Exception e){
            result.setFlag(false);
            return result;
        }
        result.setFlag(true);
        result.setData(newsList);
        return result;
    }
    /**
     * 查看点赞过的评论，用户在个人中心可以查看。
     */
    @ApiOperation("查看点赞过的评论")
    @GetMapping("/personal/comments/{userId}")
    public Result viewLikedComment(@PathVariable Long userId){
        System.out.println("userId:"+userId);
        System.out.println("查看点赞过的评论");
        Result result = new Result();
        List<Comment> commentList;
        try{
            List<Long> commentIdList = likeCommentService.getlikeCommentByUserId(userId);
            commentList = commentService.getCommentListByCommentIdList(commentIdList);
        } catch (Exception e){
            result.setFlag(false);
            return result;
        }
        result.setFlag(true);
        result.setData(commentList);
        return result;
    }
    /**
     * 获取用户收藏的新闻
     */
    @ApiOperation("获取用户收藏的新闻")
    @GetMapping("/personal/collection/{userId}")
    public Result getCollection(@PathVariable Long userId){
        System.out.println("userId:"+userId);
        System.out.println("获取用户收藏的新闻");
        Result result = new Result();
        List<Long> newsIdList = userCollectionService.getNewsIdListByUserId(userId);
        List<News> newsList = newsService.getNewsByNewsIdList(newsIdList);
        result.setFlag(true);
        result.setData(newsList);
        return result;
    }
}
