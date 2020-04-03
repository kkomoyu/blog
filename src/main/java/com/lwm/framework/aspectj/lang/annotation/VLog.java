package com.lwm.framework.aspectj.lang.annotation;

import java.lang.annotation.*;

/**
 * @Auther: guya
 * @Date: 2020/3/19 22:55
 * @Description: 自定义访问日志注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VLog {
    /**
     * 请求的模块
     */
    String title() default "";

    int blogId() default 0;
}

