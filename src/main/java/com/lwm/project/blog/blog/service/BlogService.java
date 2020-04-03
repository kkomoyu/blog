package com.lwm.project.blog.blog.service;

import com.lwm.project.blog.blog.domain.Blog;
import com.lwm.project.dashboard.domain.BusinessCommonData;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/19 22:31
 * @Description:
 */
public interface BlogService {

    /**
     * @Description:  根据条件查询所有的blog
     * @Param [blog]
     * @return java.util.List<com.lwm.project.blog.blog.domain.Blog>
     */
    List<Blog> selectBlogList(Blog blog);

    /**
     * @Description: 新增博客
     * @Param [blog]
     * @return int
     */
    int insertBlog(Blog blog);

    /**
     * @Description: 根据id查询blog
     * @Param [blogId]
     * @return com.lwm.project.blog.blog.domain.Blog
     */
    Blog selectBlogById(Integer blogId);

    /**
     * @Description: 修改blog信息
     * @Param [blog]
     * @return int
     */
    int updateBlog(Blog blog);

    /**
     * @Description: 切换support状态
     * @Param [blogId, support]
     * @return int
     */
    int updateBlogSupportById(Integer blogId,String support);

    /**
     * @Description: 切换博客的状态
     * @Param [blogIds, status]
     * @return int
     */
    int updateBlogStatusById(String blogIds,String status);

    /**
     * @Description: 删除博客
     * @Param [ids]
     * @return int
     */
    int deleteBlogById(Integer ids[]);

    /**
     * @Description: 根据Blog的状态统计数量
     * @Param [status]
     * @return int
     */
    int selectBlogCountByStatus(int status);

    /**
     * @Description: 根据Blog的id获取blog信息，包括tag
     * @Param [blogId]
     * @return com.lwm.project.blog.blog.domain.Blog
     */
    Blog selectBlogWithTextAndTagsAndCategoryByBlogId(Integer blogId);

    /**
     * @Description: 获取最新更新的blog
     * @Param []
     * @return java.util.List<com.lwm.project.blog.blog.domain.Blog>
     */
    List<Blog> selectNewestUpdateBlog();

    /**
     * @Description: 获取文章排行
     * @Param []
     * @return java.util.List<com.lwm.project.blog.blog.domain.Blog>
     */
    List<Blog> selectBlogRanking();

    /**
     * @Description: 获取推荐博文
     * @Param []
     * @return java.util.List<com.lwm.project.blog.blog.domain.Blog>
     */
    List<Blog> selectSupportBlog();

    /**
     * @Description: 获取当前Blog的上一篇Blog
     * @Param [blogId]
     * @return com.lwm.project.blog.blog.domain.Blog
     */
    Blog selectPreviousBlogById(Integer blogId);

    /**
     * @Description: 获取下一篇博客
     * @Param [blogId]
     * @return com.lwm.project.blog.blog.domain.Blog
     */
    Blog selectNextBlogById(Integer blogId);

    /**
     * @Description: 获取随机的blog列表
     * @Param []
     * @return java.util.List<com.lwm.project.blog.blog.domain.Blog>
     */
    List<Blog> selectRandBlogList();

    /**
     * @Description: 据tag的id查询blog列表
     * @Param [tagId]
     * @return java.util.List<com.lwm.project.blog.blog.domain.Blog>
     */
    List<Blog> selectBlogListByTagId(Integer tagId);

    /**
     * @Description: 图表展示博客点击量统计
     * @Param [startTime, endTime]
     * @return java.util.List<com.lwm.project.dashboard.domain.BusinessCommonData>
     */
    List<BusinessCommonData> selectBlogClickData (String startTime,String endTime);
}
