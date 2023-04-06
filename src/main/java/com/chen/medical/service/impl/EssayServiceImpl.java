package com.chen.medical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.medical.common.DeleteRequest;
import com.chen.medical.common.ErrorCode;
import com.chen.medical.exception.BusinessException;
import com.chen.medical.exception.ThrowUtils;
import com.chen.medical.model.entity.Essay;
import com.chen.medical.model.dto.essay.EssayAddRequest;
import com.chen.medical.model.dto.essay.EssayQueryRequest;
import com.chen.medical.model.vo.EssayVO;
import com.chen.medical.service.EssayService;
import com.chen.medical.mapper.EssayMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjiahan
 * @description 针对表【essay(文章)】的数据库操作Service实现
 * @createDate 2023-04-05 09:59:22
 */
@Service
public class EssayServiceImpl extends ServiceImpl<EssayMapper, Essay>
        implements EssayService {

    @Override
    public Long addEssay(EssayAddRequest essayAddRequest) {
        // todo 同步到ElasticSearch上
        if (essayAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Essay essay = new Essay();
        BeanUtils.copyProperties(essayAddRequest, essay);
        this.validEssay(essay, true);
        boolean result = this.save(essay);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return essay.getId();
    }

    @Override
    public Boolean deleteEssay(DeleteRequest deleteRequest) {
        Long id = deleteRequest.getId();
        Essay oldEssay = this.getById(id);
        ThrowUtils.throwIf(oldEssay == null, ErrorCode.NOT_FOUND_ERROR);
        return this.removeById(id);
    }

    @Override
    public void validEssay(Essay essay, boolean add) {
        if (essay == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String author = essay.getAuthor();
        String title = essay.getTitle();
        String content = essay.getContent();
        String tags = essay.getTags();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(title, content, tags), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(title) && title.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }
        if (StringUtils.isNotBlank(content) && content.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "简介过长");
        }
        if (StringUtils.isNotBlank(author) && author.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }

    @Override
    public QueryWrapper<Essay> getQueryWrapper(EssayQueryRequest postQueryRequest) {
        return null;
    }

    @Override
    public Page<Essay> searchFromEs(EssayQueryRequest postQueryRequest) {
        return null;
    }

    @Override
    public EssayVO getEssayVO(Essay post, HttpServletRequest request) {
        return null;
    }

    @Override
    public Page<EssayVO> getEssayVOPage(Page<Essay> postPage, HttpServletRequest request) {
        return null;
    }

    @Override
    public Page<EssayVO> listEssayVOByPage(EssayQueryRequest postQueryRequest, HttpServletRequest request) {
        return null;
    }
}




