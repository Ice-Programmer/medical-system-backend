package com.chen.medical.model.dto.essayfavour;

import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/16 10:47
 */
@Data
public class EssayFavourAddRequest implements Serializable {
    /**
     * 帖子 id
     */
    private Long essayId;

    private static final long serialVersionUID = 1L;
}
