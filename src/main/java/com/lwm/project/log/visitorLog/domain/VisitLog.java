package com.lwm.project.log.visitorLog.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/20 09:41
 * @Description: 访问日志
 */
@Data
public class VisitLog extends BaseEntity {
    private Integer visitId;
    /**
     * IP地址
     */
    private String ipAddr;
    /**
     * ip地理位置
     */
    private String location;
    /**
     * 浏览器类型
     */
    private String browser;
    /**
     * 操作系统类型
     */
    private String os;
    /**
     * 爬虫
     */
    private String spider;
    /**
     * 请求的地址
     */
    private String requestUrl;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 访问的模块
     */
    private String title;
    /**
     * 访问状态
     */
    private Integer status;
}
