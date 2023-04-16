package com.chen.medical.model.dto.essayfavour;

import com.chen.medical.common.PageRequest;
import com.chen.medical.model.dto.essay.EssayQueryRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/16 10:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class EssayFavourQueryRequest extends PageRequest implements Serializable {

    /**
     * 帖子查询请求
     */
    private EssayQueryRequest essayQueryRequest;

    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
