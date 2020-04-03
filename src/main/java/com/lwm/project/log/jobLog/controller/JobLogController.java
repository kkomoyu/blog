package com.lwm.project.log.jobLog.controller;

import com.lwm.common.utils.poi.ExcelUtil;
import com.lwm.framework.aspectj.lang.annotation.Log;
import com.lwm.framework.aspectj.lang.enums.BusinessType;
import com.lwm.framework.web.controller.BaseController;
import com.lwm.framework.web.domain.AjaxResult;
import com.lwm.framework.web.page.TableDataInfo;
import com.lwm.project.log.jobLog.domain.JobLog;
import com.lwm.project.log.jobLog.service.IJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Auther: guya
 * @Date: 2020/3/21 10:54
 * @Description:
 */
@Controller
@RequestMapping("/log/jobLog")
public class JobLogController extends BaseController {
    private String prefix = "log/jobLog";

    @Autowired
    private IJobLogService jobLogService;

    @RequiresPermissions("log:job:view")
    @GetMapping()
    public String jobLog() {
        return prefix + "/jobLog";
    }

    @RequiresPermissions("log:job:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(JobLog jobLog) {
        startPage();
        List<JobLog> list = jobLogService.selectJobLogList(jobLog);
        return getDataTable(list);
    }

    @Log(title = "调度日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("log:job:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JobLog jobLog) {
        List<JobLog> list = jobLogService.selectJobLogList(jobLog);
        ExcelUtil<JobLog> util = new ExcelUtil<JobLog>(JobLog.class);
        return util.exportExcel(list, "调度日志");
    }

    @Log(title = "调度日志", businessType = BusinessType.DELETE)
    @RequiresPermissions("log:job:remove")
    @DeleteMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(jobLogService.deleteJobLogByIds(ids));
    }

    @RequiresPermissions("log:job:detail")
    @GetMapping("/detail/{jobLogId}")
    public String detail(@PathVariable("jobLogId") Long jobLogId, ModelMap mmap) {
        mmap.put("name", "jobLog");
        mmap.put("jobLog", jobLogService.selectJobLogById(jobLogId));
        return prefix + "/detail";
    }

    @Log(title = "调度日志", businessType = BusinessType.CLEAN)
    @RequiresPermissions("log:job:remove")
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        jobLogService.cleanJobLog();
        return success();
    }
}
