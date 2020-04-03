package com.lwm.project.blog.tag.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/19 19:57
 * @Description:
 */
@Data
public class Tag extends BaseEntity {

    private static final long serialVersionUID = 1L;


    private Integer tagId;

    /**
     * 标签内容
     */
    private String tagTitle;
    /**
     * 关联的博客个数
     */
    private int count;
}