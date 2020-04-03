package com.lwm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:54
 * @Description: 启动程序
 */
@SpringBootApplication
@MapperScan("com.lwm.project.**.mapper")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }
}