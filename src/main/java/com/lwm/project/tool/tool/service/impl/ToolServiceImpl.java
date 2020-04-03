package com.lwm.project.tool.tool.service.impl;

import com.lwm.project.tool.tool.domain.Tool;
import com.lwm.project.tool.tool.mapper.BgToolMapper;
import com.lwm.project.tool.tool.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:40
 * @Description: 用工具(Tool) Service实现层
 */
@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private BgToolMapper bgToolMapper;

    @Override
    public Tool selectToolById(Integer toolId) {
        return this.bgToolMapper.selectToolById(toolId);
    }

    @Override
    public List<Tool> selectToolList(Tool tool) {
        return this.bgToolMapper.selectToolList(tool);
    }

    @Override
    public int insertTool(Tool tool) {
        return bgToolMapper.insertTool(tool);
    }

    @Override
    public int updateTool(Tool tool) {
        return bgToolMapper.updateTool(tool);
    }

    @Override
    public int deleteToolByIds(Integer[] toolId) {
        return bgToolMapper.deleteToolByIds(toolId);
    }
}