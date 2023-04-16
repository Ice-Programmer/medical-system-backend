package com.chen.medical.model.vo;

import com.chen.medical.model.entity.Essay;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 文章
 */
@Data
public class EssayVO implements Serializable {

    private final static Gson GSON = new Gson();

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
     * 文章内容
     */
    private String article;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    /**
     * 文章地址
     */
    private List<String> tagList;

    /**
     * 创建用户Id
     */
    private Long userId;

    /**
     * 创建人信息
     */
    private UserVO user;

    /**
     * 是否已点赞
     */
    private Boolean hasThumb;

    /**
     * 是否已收藏
     */
    private Boolean hasFavour;

    /**
     * 包装类转对象
     *
     * @param essayVO
     * @return
     */
    public static Essay voToObj(EssayVO essayVO) {
        if (essayVO == null) {
            return null;
        }
        Essay essay = new Essay();
        BeanUtils.copyProperties(essayVO, essay);
        List<String> tagList = essayVO.getTagList();
        if (tagList != null) {
            essay.setTags(GSON.toJson(tagList));
        }
        return essay;
    }

    /**
     * 对象转包装类
     *
     * @param essay
     * @return
     */
    public static EssayVO objToVo(Essay essay) {
        if (essay == null) {
            return null;
        }
        EssayVO essayVO = new EssayVO();
        BeanUtils.copyProperties(essay, essayVO);
        essayVO.setTagList(GSON.fromJson(essay.getTags(), new TypeToken<List<String>>() {
        }.getType()));
        return essayVO;
    }

    private static final long serialVersionUID = 1L;
}