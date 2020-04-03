package com.lwm.project.tool.tool.controller;

import com.lwm.framework.aspectj.lang.annotation.Log;
import com.lwm.framework.aspectj.lang.enums.BusinessType;
import com.lwm.framework.web.controller.BaseController;
import com.lwm.framework.web.domain.AjaxResult;
import com.lwm.framework.web.page.TableDataInfo;
import com.lwm.project.tool.tool.domain.Tool;
import com.lwm.project.tool.tool.service.ToolService;
import com.lwm.project.tool.toolCategory.domain.ToolCategory;
import com.lwm.project.tool.toolCategory.service.ToolCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 22:45
 * @Description: 常用工具(Tool) Controller层
 */
@RestController
@RequestMapping("/tool/tool/")
public class ToolController extends BaseController {
    @Autowired
    ToolService toolService;

    @Autowired
    ToolCategoryService toolCategoryService;

    @RequiresPermissions("tool:tool:view")
    @GetMapping()
    public String tool() {
        return "tool/tool/tool";
    }

    @GetMapping("/list")
    @RequiresPermissions("blog:blog:list")
    @ResponseBody
    public TableDataInfo list(Tool tool) {
        startPage();
        List<Tool> list = toolService.selectToolList(tool);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("toolCategories", toolCategoryService.selectToolCategoryList(new ToolCategory()));
        return "tool/tool/add";
    }

    @Log(title = "工具管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("tool:tool:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Tool tool) {
        return toAjax(toolService.insertTool(tool));
    }

    @GetMapping("/edit/{toolId}")
    public String edit(@PathVariable Integer toolId, Model model) {
        model.addAttribute("tool", toolService.selectToolById(toolId));
        model.addAttribute("toolCategories", toolCategoryService.selectToolCategoryList(new ToolCategory()));
        return "tool/tool/edit";
    }

    @PutMapping("/edit")
    @RequiresPermissions("tool:tool:edit")
    @Log(title = "工具管理", businessType = BusinessType.UPDATE)
    @ResponseBody
    public AjaxResult editSave(Tool tool) {
        return toAjax(toolService.updateTool(tool));
    }

    @DeleteMapping("/remove")
    @Log(title = "工具管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("blog:blog:remove")
    @ResponseBody
    public AjaxResult remove(Integer[] ids) {
        return toAjax(toolService.deleteToolByIds(ids));
    }


}