package com.chen.medical.controller;

import com.chen.medical.common.BaseResponse;
import com.chen.medical.common.ErrorCode;
import com.chen.medical.common.ResultUtils;
import com.chen.medical.exception.BusinessException;
import com.chen.medical.model.dto.essaythumb.EssayThumbAddRequest;
import com.chen.medical.model.entity.User;
import com.chen.medical.service.EssayThumbService;
import com.chen.medical.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/16 13:41
 */
@RestController
@RequestMapping("/essay_thumb")
@Slf4j
public class EssayThumbController {
    @Resource
    private EssayThumbService postThumbService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param essayThumbAddRequest 文章点赞请求
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Integer> doThumb(@RequestBody EssayThumbAddRequest essayThumbAddRequest,
                                         HttpServletRequest request) {
        if (essayThumbAddRequest == null || essayThumbAddRequest.getEssayId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long essayId = essayThumbAddRequest.getEssayId();
        int result = postThumbService.doEssayThumb(essayId, loginUser);
        return ResultUtils.success(result);
    }

}
