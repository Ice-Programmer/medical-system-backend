package com.chen.medical.service;

import com.chen.medical.model.entity.EssayThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.medical.model.entity.User;

/**
* @author chenjiahan
* @description 针对表【essay_thumb(文章点赞)】的数据库操作Service
* @createDate 2023-04-16 10:31:33
*/
public interface EssayThumbService extends IService<EssayThumb> {

    /**
     * 点赞
     *
     * @param essayId
     * @param loginUser
     * @return
     */
    int doEssayThumb(long essayId, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId
     * @param essayId
     * @return
     */
    int doEssayThumbInner(long userId, long essayId);
}
