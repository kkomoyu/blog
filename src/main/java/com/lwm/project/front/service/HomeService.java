package com.lwm.project.front.service;

import com.lwm.project.blog.blog.domain.Blog;
import com.lwm.project.front.domain.Archives;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:08
 * @Description:
 */
public interface HomeService {
    /**
     * 获取最新的blog
     *
     * @param blog
     * @return 最新的blog的集合
     */
    List<Blog> selectFrontBlogList(Blog blog);

    /**
     * 获取归档信息
     *
     * @return 归档集合
     */
    List<Archives> selectArchives();
}