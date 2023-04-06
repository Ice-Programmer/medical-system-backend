package com.chen.medical.model.dto.essay;

import lombok.Data;

import java.io.Serializable;

/**
 * 文章搜索
 */
@Data
public class EssayQueryRequest implements Serializable {
    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 简介
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    private static final long serialVersionUID = 1L;
}