package com.lwm.project.file.img;

import com.lwm.common.utils.file.QiNiuUtils;
import com.lwm.framework.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:06
 * @Description:
 */
@Controller
public class ImgController {
    @Autowired
    QiNiuUtils qiNiuUtils;

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list() {
        List<String> list = qiNiuUtils.selectImgList();
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @GetMapping("/file/img")
    public String img(Model model) {
        model.addAttribute("list", qiNiuUtils.selectImgList());
        return "file/img/img";
    }
}