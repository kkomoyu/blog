package com.lwm.project.dashboard.domain;

import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/21 08:10
 * @Description:
 */
@Data

public class VisitCount {
    /**
     * 访问日期
     */
    private String date;
    /**
     * 访问量
     */
    private Integer value;
}