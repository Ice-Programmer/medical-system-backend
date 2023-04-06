package com.chen.medical.model.dto.essay;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.chen.medical.model.entity.Essay;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2023/4/6 09:59
 */
@Document(indexName = "essay")
@Data
public class EssayEsDTO implements Serializable {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String content;

    /**
     * 文章内容
     */
    private String article;

    /**
     * 作者
     */
    private String author;

    /**
     * 路径
     */
    private String path;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 创建时间
     */
    @Field(index = false, store = true, type = FieldType.Date, format = {}, pattern = DATE_TIME_PATTERN)
    private Date createTime;

    /**
     * 更新时间
     */
    @Field(index = false, store = true, type = FieldType.Date, format = {}, pattern = DATE_TIME_PATTERN)
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    private static final Gson GSON = new Gson();
    
    /**
     * 对象转包装类
     *
     * @param essay
     * @return
     */
    public static EssayEsDTO objToDto(Essay essay) {
        if (essay == null) {
            return null;
        }
        EssayEsDTO essayEsDTO = new EssayEsDTO();
        BeanUtils.copyProperties(essay, essayEsDTO);
        String tagsStr = essay.getTags();
        if (StringUtils.isNotBlank(tagsStr)) {
            essayEsDTO.setTags(GSON.fromJson(tagsStr, new TypeToken<List<String>>() {
            }.getType()));
        }
        return essayEsDTO;
    }

    /**
     * 包装类转对象
     *
     * @param essayEsDTO
     * @return
     */
    public static Essay dtoToObj(EssayEsDTO essayEsDTO) {
        if (essayEsDTO == null) {
            return null;
        }
        Essay essay = new Essay();
        BeanUtils.copyProperties(essayEsDTO, essay);
        List<String> tagList = essayEsDTO.getTags();
        if (CollectionUtils.isNotEmpty(tagList)) {
            essay.setTags(GSON.toJson(tagList));
        }
        return essay;
    }

}
