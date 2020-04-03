package com.lwm;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:57
 * @Description: web容器进行部署初始化
 */
public class BlogServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(BlogApplication.class);
    }
}