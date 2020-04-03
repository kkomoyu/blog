package com.lwm.project.monitor.swagger;

import com.lwm.framework.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: guya
 * @Date: 2020/3/21 21:17
 * @Description: swagger 接口
 */
@Controller
@RequestMapping("/monitor/swagger")
public class SwaggerController extends BaseController {
    @RequiresPermissions("monitor:swagger:view")
    @GetMapping()
    public String index() {
        return redirect("/swagger-ui.html");
    }
}