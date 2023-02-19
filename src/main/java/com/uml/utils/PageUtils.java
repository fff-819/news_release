package com.uml.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.uml.pojo.Pages;
import org.springframework.stereotype.Component;

@Component
public class PageUtils {
    /**
     * 分页信息返回工具
     */
    /**
     * 返回处理过的页面信息
     */
    public static Pages myPage(IPage pages){
        Pages returnPage = new Pages();
        returnPage.setCurrent(pages.getCurrent());
        returnPage.setList(pages.getRecords());
        returnPage.setSize(pages.getSize());
        returnPage.setTotal(pages.getTotal());
        return returnPage;
    }
}
