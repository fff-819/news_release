package com.uml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uml.pojo.UserCollection;

import java.util.List;

public interface UserCollectionService extends IService<UserCollection> {
    /**
     * 取消收藏
     * @param userId
     * @param newsId
     * @return
     */
    Boolean notCollect(Long userId,Long newsId);

    /**
     * 查看用户是否收藏了该新闻
     * @param userId
     * @param newsId
     * @return
     */
    Boolean selectCollectByUserIdAndNewsId(Long userId,Long newsId);
    /**
     * 获取用户所有收藏的新闻id
     */
    List<Long> getNewsIdListByUserId(Long userId);
}
