package com.lwm.project.link.controller;

import com.lwm.framework.aspectj.lang.annotation.Log;
import com.lwm.framework.aspectj.lang.enums.BusinessType;
import com.lwm.framework.web.controller.BaseController;
import com.lwm.framework.web.domain.AjaxResult;
import com.lwm.framework.web.page.TableDataInfo;
import com.lwm.project.link.domain.Link;
import com.lwm.project.link.service.LinkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:21
 * @Description:
 */
@Controller
@RequestMapping("/link/link")
public class LinkController extends BaseController {

    @Autowired
    LinkService linkService;

    @RequiresPermissions("link:link:view")
    @GetMapping()
    public String link(Model model) {
        model.addAttribute("map", linkService.selectLinkCount());
        return "link/link";
    }

    @RequiresPermissions("link:link:list")
    @GetMapping("list")
    @ResponseBody
    public TableDataInfo list(Link link) {
        startPage();
        List<Link> list = linkService.selectLinkList(link);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add() {
        return "link/add";
    }

    @PostMapping("/add")
    @ResponseBody
    @RequiresPermissions("link:link:add")
    public AjaxResult addSave(Link link) {
        return toAjax(linkService.insertLink(link));
    }

    @GetMapping("/edit/{linkId}")
    public String edit(@PathVariable Integer linkId, Model model) {
        model.addAttribute("link", linkService.selectLinkById(linkId));
        return "link/edit";
    }

    @PutMapping("/edit")
    @Log(title = "友链管理", businessType = BusinessType.UPDATE)
    @ResponseBody
    @RequiresPermissions("link:link:edit")
    public AjaxResult editSave(Link link) {
        return toAjax(linkService.updateLink(link));
    }

    @RequiresPermissions("link:link:remove")
    @Log(title = "友链管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(linkService.deleteLinkByIds(ids));
    }

    @Log(title = "友链管理", businessType = BusinessType.UPDATE)
    @PutMapping("/display/{display}")
    @RequiresPermissions("link:link:display")
    @ResponseBody
    public AjaxResult display(Integer id, @PathVariable Integer display) {
        return toAjax(linkService.changeDisplay(id, display));
    }

    /**
     * 通过友链
     */
    @Log(title = "友链管理", businessType = BusinessType.UPDATE)
    @PutMapping("/processed")
    @RequiresPermissions("link:link:pass")
    @ResponseBody
    public AjaxResult processed(String ids) {
        return toAjax(linkService.processedLinkByIds(ids));
    }

}
