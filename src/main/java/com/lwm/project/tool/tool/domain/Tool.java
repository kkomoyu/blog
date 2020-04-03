package com.lwm.project.tool.tool.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:37
 * @Description: 常用工具(Tool)实体类
 */
@Data
public class Tool extends BaseEntity {
    private static final long serialVersionUID = -29134451060966794L;

    private Integer toolId;
    //工具名称
    private String toolName;
    //工具描述
    private String description;
    //显示状态，1表示显示，0表示不显示
    private String display;
    //链接地址
    private String url;

    private String type;
    //头像地址
    private String headImg;
    //权重
    private Integer weight;

    private Integer toolCategoryId;
}