package com.lwm.project.front.domain;

import com.lwm.project.blog.blog.domain.Blog;
import lombok.Data;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/19 20:30
 * @Description: 归档VO
 */
@Data
public class Archives {
    private String date;
    private Integer count;
    private List<Blog> blogs;
}