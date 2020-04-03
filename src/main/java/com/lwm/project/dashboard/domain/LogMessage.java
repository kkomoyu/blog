package com.lwm.project.dashboard.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: guya
 * @Date: 2020/3/20 09:39
 * @Description: dashboard展示的最新消息
 */
@Data
public class LogMessage {
    /**
     * Date String ,如“刚刚”等
     */
    String dateStr;
    /**
     * 具体时间
     */
    Date date;
    /**
     * 消息
     */
    String message;
}
