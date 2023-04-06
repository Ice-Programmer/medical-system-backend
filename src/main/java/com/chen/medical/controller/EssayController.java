package com.chen.medical.controller;

import com.chen.medical.common.BaseResponse;
import com.chen.medical.common.DeleteRequest;
import com.chen.medical.common.ErrorCode;
import com.chen.medical.common.ResultUtils;
import com.chen.medical.exception.BusinessException;
import com.chen.medical.exception.ThrowUtils;
import com.chen.medical.model.dto.essay.EssayAddRequest;
import com.chen.medical.service.EssayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文章接口
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/5 10:01
 */
@RestController
@Slf4j
@RequestMapping("/essay")
public class EssayController {

    @Resource
    private EssayService essayService;

    /**
     * 创建文章
     * @param essayAddRequest 增加文章请求
     * @return 文章id
     */
    @PostMapping("/add")
    public BaseResponse<Long> addEssay(@RequestBody EssayAddRequest essayAddRequest) {
        ThrowUtils.throwIf(essayAddRequest == null, ErrorCode.PARAMS_ERROR);
        Long essayId = essayService.addEssay(essayAddRequest);
        return ResultUtils.success(essayId);
    }

    /**
     * 删除文章信息
     * @param deleteRequest 删除id
     * @return 删除结果
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteEssay(@RequestBody DeleteRequest deleteRequest) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Boolean result = essayService.deleteEssay(deleteRequest);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "删除文章失败");
        }
        return ResultUtils.success(true);
    }

}
