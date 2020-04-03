package com.lwm.project.chart.server.controller;

import com.lwm.framework.web.controller.BaseController;
import com.lwm.project.chart.server.domain.Server;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: guya
 * @Date: 2020/3/21 00:32
 * @Description: 服务器监控
 */
@Controller
@RequestMapping("/chart/server")
public class ServerController extends BaseController {
    private String prefix = "chart/server";

    @RequiresPermissions("chart:server:view")
    @GetMapping()
    public String server(ModelMap mmap) throws Exception {
        Server server = new Server();
        server.copyTo();
        mmap.put("server", server);
        return prefix + "/server";
    }
}