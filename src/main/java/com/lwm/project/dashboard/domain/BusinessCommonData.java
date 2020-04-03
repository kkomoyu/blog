package com.lwm.project.dashboard.domain;

import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/19 20:27
 * @Description: 业务公共数据模型
 */
@Data
public class BusinessCommonData {
    /**
     * 名称
     */
    private String name;
    /**
     * 值
     */
    private Integer value;
}