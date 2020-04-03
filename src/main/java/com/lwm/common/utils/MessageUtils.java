package com.lwm.common.utils;

import com.lwm.common.utils.spring.SpringUtils;
import org.springframework.context.MessageSource;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:20
 * @Description: 获取i18n资源文件
 */
public class MessageUtils {
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, null);
    }
}