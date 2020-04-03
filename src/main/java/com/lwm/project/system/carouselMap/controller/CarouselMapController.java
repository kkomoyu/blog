package com.lwm.project.system.carouselMap.controller;

import com.lwm.framework.aspectj.lang.annotation.Log;
import com.lwm.framework.aspectj.lang.enums.BusinessType;
import com.lwm.framework.web.controller.BaseController;
import com.lwm.framework.web.domain.AjaxResult;
import com.lwm.framework.web.page.TableDataInfo;
import com.lwm.project.system.carouselMap.domain.CarouselMap;
import com.lwm.project.system.carouselMap.service.CarouselMapService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 21:23
 * @Description: 轮播图设置(CarouselMap)表控制层
 */
@Controller
@RequestMapping("/system/carouselMap")
public class CarouselMapController extends BaseController {

    @Resource
    private CarouselMapService carouselMapService;

    @RequiresPermissions("system:carouselMap:view")
    @GetMapping
    public String carouselMap() {
        return "system/carouselMap/carouselMap";
    }

    @GetMapping("/list")
    @RequiresPermissions("system:carouselMap:list")
    @ResponseBody
    public TableDataInfo list(CarouselMap carouselMap) {
        startPage();
        List<CarouselMap> list = carouselMapService.selectCarouselMapList(carouselMap);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "system/carouselMap/add";
    }

    @Log(title = "轮播图设置", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:carouselMap:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CarouselMap carouselMap) {
        return toAjax(carouselMapService.insertCarouselMap(carouselMap));
    }

    @GetMapping("/edit/{carouselMapId}")
    public String edit(@PathVariable Integer carouselMapId, Model model) {
        model.addAttribute("carouselMap", carouselMapService.selectCarouselMapById(carouselMapId));
        return "system/carouselMap/edit";
    }

    @PutMapping("/edit")
    @RequiresPermissions("system:carouselMap:edit")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @ResponseBody
    public AjaxResult editSave(CarouselMap carouselMap) {
        return toAjax(carouselMapService.updateCarouselMap(carouselMap));
    }

    @PutMapping("/changeDisplay/{display}")
    @RequiresPermissions("system:carouselMap:edit")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @ResponseBody
    public AjaxResult editSave(@PathVariable String display, String carouselId) {
        return toAjax(carouselMapService.changeCarouselDisplay(carouselId,display));
    }


    @DeleteMapping("/remove")
    @Log(title = "博客管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:carouselMap:remove")
    @ResponseBody
    public AjaxResult remove(Integer[] ids) {
        return toAjax(carouselMapService.deleteCarouselMapByIds(ids));
    }
}