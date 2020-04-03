package com.lwm.project.tool.toolCategory.service.impl;

import com.lwm.project.tool.toolCategory.domain.ToolCategory;
import com.lwm.project.tool.toolCategory.mapper.ToolCategoryMapper;
import com.lwm.project.tool.toolCategory.service.ToolCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:49
 * @Description: 工具的分类(ToolCategory) Service实现层
 */
@Service
public class ToolCategoryServiceImpl implements ToolCategoryService {
    @Autowired
    private ToolCategoryMapper toolCategoryMapper;

    @Override
    public ToolCategory selectToolCategoryById(Integer toolCategoryId) {
        return this.toolCategoryMapper.selectToolCategoryById(toolCategoryId);
    }

    @Override
    public List<ToolCategory> selectToolCategoryList(ToolCategory toolCategory) {
        return this.toolCategoryMapper.selectToolCategoryList(toolCategory);
    }

    @Override
    public int insertToolCategory(ToolCategory toolCategory) {
        return toolCategoryMapper.insertToolCategory(toolCategory);
    }

    @Override
    public int updateToolCategory(ToolCategory toolCategory) {
        return toolCategoryMapper.updateToolCategory(toolCategory);
    }

    @Override
    public int deleteToolCategoryByIds(Integer[] toolCategoryId) {
        return toolCategoryMapper.deleteToolCategoryByIds(toolCategoryId);
    }
}