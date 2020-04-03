package com.lwm.project.front.service.impl;

import com.lwm.project.blog.blog.domain.Blog;
import com.lwm.project.blog.blog.mapper.BlogMapper;
import com.lwm.project.front.domain.Archives;
import com.lwm.project.front.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:09
 * @Description:
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> selectFrontBlogList(Blog blog) {
        List<Blog> blogs = blogMapper.selectFrontBlogList(blog);
        return blogs;
    }

    @Override
    public List<Archives> selectArchives() {
        List<Archives> archives = blogMapper.selectArchivesDateAndCount();
        for (Archives archive : archives) {
            archive.setBlogs(blogMapper.selectBlogByCreateTime(archive.getDate()));
        }
        return archives;
    }
}
