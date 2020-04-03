package com.lwm.project.common;

import com.lwm.common.utils.file.QiNiuUtils;
import com.lwm.framework.aspectj.lang.annotation.Log;
import com.lwm.framework.aspectj.lang.enums.BusinessType;
import com.lwm.framework.web.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 00:46
 * @Description: 七牛云图片上传处理
 */
@Controller
@Slf4j
@RequestMapping("/qiniu/image")
public class QiNiuController {

    @Autowired
    QiNiuUtils qiNiuUtils;

    @GetMapping()
    @RequiresPermissions("qiniu:image:view")
    public String qiniuyun() {
        return "";
    }

    @PostMapping("/upload")
    @Log(title = "图片管理", businessType = BusinessType.UPLOAD)
    @RequiresPermissions("qiniu:image:upload")
    @ResponseBody
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {
        String s = qiNiuUtils.uploadImgToQiNiu(file);
        return AjaxResult.success().put("data", s);
    }

    @DeleteMapping("/remove")
    @Log(title = "图片管理", businessType = BusinessType.DELETE)
    @ResponseBody
    public boolean remove(String fileUrl) {
        log.info("删除图片{}", fileUrl);
        boolean b = qiNiuUtils.deleteImgFromQiNiu(fileUrl);
        return b;
    }

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list() {
        List<String> list = qiNiuUtils.selectImgList();
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

}