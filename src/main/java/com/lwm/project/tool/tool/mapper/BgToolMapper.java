package com.lwm.project.tool.tool.mapper;

import com.lwm.project.tool.tool.domain.Tool;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:38
 * @Description: 常用工具(Tool) Dao层
 */
public interface BgToolMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param toolId 主键
     * @return 实例对象
     */
    Tool selectToolById(Integer toolId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tool 实例对象
     * @return 对象列表
     */
    List<Tool> selectToolList(Tool tool);

    /**
     * 新增数据
     *
     * @param tool 实例对象
     * @return 影响行数
     */
    int insertTool(Tool tool);

    /**
     * 修改数据
     *
     * @param tool 实例对象
     * @return 影响行数
     */
    int updateTool(Tool tool);

    /**
     * 通过主键删除数据
     *
     * @param toolId 主键
     * @return 影响行数
     */
    int deleteToolByIds(Integer[] toolId);

}