package com.lwm.project.blog.category.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/19 19:56
 * @Description:
 */
@Data
public class Category extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer categoryId;
    /**
     * 分类的名称
     */
    private String categoryTitle;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 描述
     */
    private String description;
    /**
     * 是否推荐，0表示不推荐，1表示推荐
     */
    private String support;
}