package com.lwm.framework.aspectj.lang.annotation;

import java.lang.annotation.*;

/**
 * @Auther: guya
 * @Date: 2020/3/19 22:55
 * @Description: 数据权限过滤注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 表的别名
     */
    String tableAlias() default "";
}
