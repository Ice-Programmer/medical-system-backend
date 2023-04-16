package com.chen.medical.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.medical.model.entity.Essay;
import com.chen.medical.model.entity.EssayFavour;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenjiahan
 * @description 针对表【essay_favour(文章收藏)】的数据库操作Mapper
 * @createDate 2023-04-16 10:32:04
 * @Entity generator.entity.EssayFavour
 */
public interface EssayFavourMapper extends BaseMapper<EssayFavour> {

    /**
     * 分页查询收藏文章列表
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Essay> listFavourEssayByPage(IPage<Essay> page, @Param(Constants.WRAPPER) Wrapper<Essay> queryWrapper,
                                      long favourUserId);
}


