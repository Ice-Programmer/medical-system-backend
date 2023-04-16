package com.chen.medical.model.dto.essaythumb;

import lombok.Data;

import java.io.Serializable;

/**
 * 帖子点赞请求
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/16 13:44
 */
@Data
public class EssayThumbAddRequest implements Serializable {

    /**
     * 帖子 id
     */
    private Long essayId;

    private static final long serialVersionUID = 1L;
}
