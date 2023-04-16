package com.chen.medical.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.medical.common.BaseResponse;
import com.chen.medical.common.ErrorCode;
import com.chen.medical.common.ResultUtils;
import com.chen.medical.exception.BusinessException;
import com.chen.medical.exception.ThrowUtils;
import com.chen.medical.model.dto.essay.EssayQueryRequest;
import com.chen.medical.model.dto.essayfavour.EssayFavourAddRequest;
import com.chen.medical.model.dto.essayfavour.EssayFavourQueryRequest;
import com.chen.medical.model.entity.Essay;
import com.chen.medical.model.entity.User;
import com.chen.medical.model.vo.EssayVO;
import com.chen.medical.service.EssayFavourService;
import com.chen.medical.service.EssayService;
import com.chen.medical.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 文章收藏接口
 * 
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/16 10:43
 */
@RestController
@RequestMapping("/essay_favour")
@Slf4j
public class EssayFavourController {

    @Resource
    private EssayFavourService essayFavourService;

    @Resource
    private EssayService essayService;

    @Resource
    private UserService userService;

    /**
     * 收藏 / 取消收藏
     *
     * @param essayFavourAddRequest
     * @param request
     * @return resultNum 收藏变化数
     */
    @PostMapping("/")
    public BaseResponse<Integer> doEssayFavour(@RequestBody EssayFavourAddRequest essayFavourAddRequest,
                                               HttpServletRequest request) {
        if (essayFavourAddRequest == null || essayFavourAddRequest.getEssayId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能操作
        final User loginUser = userService.getLoginUser(request);
        long essayId = essayFavourAddRequest.getEssayId();
        int result = essayFavourService.doEssayFavour(essayId, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 获取我收藏的文章列表
     *
     * @param essayQueryRequest
     * @param request
     */
    @PostMapping("/my/list/page")
    public BaseResponse<Page<EssayVO>> listMyFavourEssayByPage(@RequestBody EssayQueryRequest essayQueryRequest,
                                                               HttpServletRequest request) {
        if (essayQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        long current = essayQueryRequest.getCurrent();
        long size = essayQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Essay> essayPage = essayFavourService.listFavourEssayByPage(new Page<>(current, size),
                essayService.getQueryWrapper(essayQueryRequest), loginUser.getId());
        return ResultUtils.success(essayService.getEssayVOPage(essayPage, request));
    }

    /**
     * 获取用户收藏的文章列表
     *
     * @param essayFavourQueryRequest
     * @param request
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<EssayVO>> listFavourEssayByPage(@RequestBody EssayFavourQueryRequest essayFavourQueryRequest,
                                                           HttpServletRequest request) {
        if (essayFavourQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long current = essayFavourQueryRequest.getCurrent();
        long size = essayFavourQueryRequest.getPageSize();
        Long userId = essayFavourQueryRequest.getUserId();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20 || userId == null, ErrorCode.PARAMS_ERROR);
        Page<Essay> essayPage = essayFavourService.listFavourEssayByPage(new Page<>(current, size),
                essayService.getQueryWrapper(essayFavourQueryRequest.getEssayQueryRequest()), userId);
        return ResultUtils.success(essayService.getEssayVOPage(essayPage, request));
    }
}
