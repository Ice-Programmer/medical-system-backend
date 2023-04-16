package com.chen.medical.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.medical.model.entity.Essay;
import com.chen.medical.model.entity.EssayFavour;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.medical.model.entity.User;

/**
* @author chenjiahan
* @description 针对表【essay_favour(文章收藏)】的数据库操作Service
* @createDate 2023-04-16 10:32:04
*/
public interface EssayFavourService extends IService<EssayFavour> {

    /**
     * 文章收藏
     *
     * @param essayId
     * @param loginUser
     * @return
     */
    int doEssayFavour(long essayId, User loginUser);

    /**
     * 分页获取用户收藏的文章列表
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Essay> listFavourEssayByPage(IPage<Essay> page, Wrapper<Essay> queryWrapper,
                                      long favourUserId);

    /**
     * 文章收藏（内部服务）
     *
     * @param userId
     * @param essayId
     * @return
     */
    int doEssayFavourInner(long userId, long essayId);
}
