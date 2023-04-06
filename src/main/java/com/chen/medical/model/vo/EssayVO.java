package com.chen.medical.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 文章
 */
@Data
public class EssayVO implements Serializable {
    /**
     * id
     */
    private Long id;

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

    /**
     * 文章地址
     */
    private String path;

    private static final long serialVersionUID = 1L;
}