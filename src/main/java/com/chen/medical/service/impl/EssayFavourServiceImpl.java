package com.chen.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.medical.common.ErrorCode;
import com.chen.medical.exception.BusinessException;
import com.chen.medical.model.entity.Essay;
import com.chen.medical.model.entity.EssayFavour;
import com.chen.medical.model.entity.User;
import com.chen.medical.service.EssayFavourService;
import com.chen.medical.mapper.EssayFavourMapper;
import com.chen.medical.service.EssayService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author chenjiahan
* @description 针对表【essay_favour(文章收藏)】的数据库操作Service实现
* @createDate 2023-04-16 10:32:04
*/
@Service
public class EssayFavourServiceImpl extends ServiceImpl<EssayFavourMapper, EssayFavour>
    implements EssayFavourService{

    @Resource
    private EssayService essayService;

    /**
     * 文章收藏
     *
     * @param essayId
     * @param loginUser
     * @return
     */
    @Override
    public int doEssayFavour(long essayId, User loginUser) {
        // 判断是否存在
        Essay essay = essayService.getById(essayId);
        if (essay == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已文章收藏
        long userId = loginUser.getId();
        // 每个用户串行文章收藏
        // 锁必须要包裹住事务方法
        EssayFavourService essayFavourService = (EssayFavourService) AopContext.currentProxy();
        synchronized (String.valueOf(userId).intern()) {
            return essayFavourService.doEssayFavourInner(userId, essayId);
        }
    }

    @Override
    public Page<Essay> listFavourEssayByPage(IPage<Essay> page, Wrapper<Essay> queryWrapper, long favourUserId) {
        if (favourUserId <= 0) {
            return new Page<>();
        }
        return baseMapper.listFavourEssayByPage(page, queryWrapper, favourUserId);
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
    public int doEssayFavourInner(long userId, long essayId) {
        EssayFavour essayFavour = new EssayFavour();
        essayFavour.setUserId(userId);
        essayFavour.setEssayId(essayId);
        QueryWrapper<EssayFavour> essayFavourQueryWrapper = new QueryWrapper<>(essayFavour);
        EssayFavour oldEssayFavour = this.getOne(essayFavourQueryWrapper);
        boolean result;
        // 已收藏
        if (oldEssayFavour != null) {
            result = this.remove(essayFavourQueryWrapper);
            if (result) {
                // 文章收藏数 - 1
                result = essayService.update()
                        .eq("id", essayId)
                        .gt("favourNum", 0)
                        .setSql("favourNum = favourNum - 1")
                        .update();
                return result ? -1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        } else {
            // 未文章收藏
            result = this.save(essayFavour);
            if (result) {
                // 文章收藏数 + 1
                result = essayService.update()
                        .eq("id", essayId)
                        .setSql("favourNum = favourNum + 1")
                        .update();
                return result ? 1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        }
    }

}




