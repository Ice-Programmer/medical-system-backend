package com.chen.medical.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.medical.common.DeleteRequest;
import com.chen.medical.model.entity.Essay;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.medical.model.dto.essay.EssayAddRequest;
import com.chen.medical.model.dto.essay.EssayQueryRequest;
import com.chen.medical.model.vo.EssayVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjiahan
 * @description 针对表【essay(文章)】的数据库操作Service
 * @createDate 2023-04-05 09:59:22
 */
public interface EssayService extends IService<Essay> {

    /**
     * 创建文章
     *
     * @param essayAddRequest 文章信息
     * @return 文章id
     */
    Long addEssay(EssayAddRequest essayAddRequest);

    /**
     * 删除文章
     *
     * @param deleteRequest 删除id
     * @return 删除结果
     */
    Boolean deleteEssay(DeleteRequest deleteRequest);

    /**
     * 校验
     *
     * @param essay 文章内容
     * @param add   是否添加
     */
    void validEssay(Essay essay, boolean add);

    /**
     * 获取查询条件
     *
     * @param essayQueryRequest
     * @return
     */
    QueryWrapper<Essay> getQueryWrapper(EssayQueryRequest essayQueryRequest);

    /**
     * 从 ES 查询
     *
     * @param essayQueryRequest
     * @return
     */
    Page<Essay> searchFromEs(EssayQueryRequest essayQueryRequest);

    /**
     * 获取文章封装
     *
     * @param essay
     * @param request
     * @return
     */
    EssayVO getEssayVO(Essay essay, HttpServletRequest request);

    /**
     * 分页获取文章封装
     *
     * @param essayPage
     * @param request
     * @return
     */
    Page<EssayVO> getEssayVOPage(Page<Essay> essayPage, HttpServletRequest request);

    /**
     * 分页查询文章
     *
     * @param essayQueryRequest
     * @param request
     * @return
     */
    Page<EssayVO> listEssayVOByPage(EssayQueryRequest essayQueryRequest, HttpServletRequest request);

}
