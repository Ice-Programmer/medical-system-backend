package com.chen.medical.model.dto.essay;

import lombok.Data;

import java.io.Serializable;

/**
 * 文章添加
 */
@Data
public class EssayAddRequest implements Serializable {
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
     * 正文
     */
    private String article;

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