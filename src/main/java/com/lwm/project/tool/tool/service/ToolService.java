package com.lwm.project.tool.tool.service;

import com.lwm.project.tool.tool.domain.Tool;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:39
 * @Description:
 */
public interface ToolService {

    /**
     * 通过ID查询单条数据
     *
     * @param toolId 主键
     * @return 实例对象
     */
    Tool selectToolById(Integer toolId);

    /**
     * 查询多条数据
     *
     * @param tool 带有查询条件的tool对象
     * @return 对象列表
     */
    List<Tool> selectToolList(Tool tool);

    /**
     * 新增数据
     *
     * @param tool 实例对象
     * @return 受影响的行数
     */
    int insertTool(Tool tool);

    /**
     * 修改数据
     *
     * @param tool 实例对象
     * @return 受影响的行数
     */
    int updateTool(Tool tool);

    /**
     * 通过主键删除数据
     *
     * @param toolId 主键
     * @return 受影响的行数
     */
    int deleteToolByIds(Integer[] toolId);

}