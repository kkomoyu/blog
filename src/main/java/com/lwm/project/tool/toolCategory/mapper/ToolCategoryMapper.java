package com.lwm.project.tool.toolCategory.mapper;

import com.lwm.project.tool.toolCategory.domain.ToolCategory;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:47
 * @Description: 工具的分类(ToolCategory) Dao层
 */
public interface ToolCategoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param toolCategoryId 主键
     * @return 实例对象
     */
    ToolCategory selectToolCategoryById(Integer toolCategoryId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param toolCategory 实例对象
     * @return 对象列表
     */
    List<ToolCategory> selectToolCategoryList(ToolCategory toolCategory);

    /**
     * 新增数据
     *
     * @param toolCategory 实例对象
     * @return 影响行数
     */
    int insertToolCategory(ToolCategory toolCategory);

    /**
     * 修改数据
     *
     * @param toolCategory 实例对象
     * @return 影响行数
     */
    int updateToolCategory(ToolCategory toolCategory);

    /**
     * 通过主键删除数据
     *
     * @param toolCategoryId 主键
     * @return 影响行数
     */
    int deleteToolCategoryByIds(Integer[] toolCategoryId);

}
