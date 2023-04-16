package com.chen.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.medical.common.ErrorCode;
import com.chen.medical.exception.BusinessException;
import com.chen.medical.model.entity.Essay;
import com.chen.medical.model.entity.EssayThumb;
import com.chen.medical.model.entity.User;
import com.chen.medical.service.EssayService;
import com.chen.medical.service.EssayThumbService;
import com.chen.medical.mapper.EssayThumbMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author chenjiahan
* @description 针对表【essay_thumb(文章点赞)】的数据库操作Service实现
* @createDate 2023-04-16 10:31:33
*/
@Service
public class EssayThumbServiceImpl extends ServiceImpl<EssayThumbMapper, EssayThumb>
    implements EssayThumbService {

    @Resource
    private EssayService essayService;

    /**
     * 点赞
     *
     * @param essayId
     * @param loginUser
     * @return
     */
    @Override
    public int doEssayThumb(long essayId, User loginUser) {
        // 判断实体是否存在，根据类别获取实体
        Essay essay = essayService.getById(essayId);
        if (essay == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已点赞
        long userId = loginUser.getId();
        // 每个用户串行点赞
        // 锁必须要包裹住事务方法
        EssayThumbService essayThumbService = (EssayThumbService) AopContext.currentProxy();
        synchronized (String.valueOf(userId).intern()) {
            return essayThumbService.doEssayThumbInner(userId, essayId);
        }
    }

    /**
     * 封装了事务的方法
     *
     * @param userId
     * @param essayId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int doEssayThumbInner(long userId, long essayId) {
        EssayThumb essayThumb = new EssayThumb();
        essayThumb.setUserId(userId);
        essayThumb.setEssayId(essayId);
        QueryWrapper<EssayThumb> thumbQueryWrapper = new QueryWrapper<>(essayThumb);
        EssayThumb oldEssayThumb = this.getOne(thumbQueryWrapper);
        boolean result;
        // 已点赞
        if (oldEssayThumb != null) {
            result = this.remove(thumbQueryWrapper);
            if (result) {
                // 点赞数 - 1
                result = essayService.update()
                        .eq("id", essayId)
                        .gt("thumbNum", 0)
                        .setSql("thumbNum = thumbNum - 1")
                        .update();
                return result ? -1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        } else {
            // 未点赞
            result = this.save(essayThumb);
            if (result) {
                // 点赞数 + 1
                result = essayService.update()
                        .eq("id", essayId)
                        .setSql("thumbNum = thumbNum + 1")
                        .update();
                return result ? 1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        }
    }

}




