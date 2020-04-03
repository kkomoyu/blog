package com.lwm.project.dashboard.controller;

import com.lwm.common.constant.BlogConstants;
import com.lwm.framework.config.SystemConfig;
import com.lwm.framework.shiro.session.OnlineSessionDAO;
import com.lwm.framework.web.controller.BaseController;
import com.lwm.framework.web.domain.AjaxResult;
import com.lwm.project.blog.blog.service.BlogService;
import com.lwm.project.chart.server.domain.Server;
import com.lwm.project.dashboard.domain.BusinessCommonData;
import com.lwm.project.dashboard.domain.VisitCount;
import com.lwm.project.dashboard.service.DashboardService;
import com.lwm.project.log.visitorLog.service.VisitLogService;
import com.lwm.project.system.menu.domain.Menu;
import com.lwm.project.system.menu.service.IMenuService;
import com.lwm.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 08:28
 * @Description: 后台首页仪表盘显示Controller
 */
@Controller
public class DashboardController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    BlogService blogService;

    @Autowired
    VisitLogService visitLogService;
    @Autowired
    DashboardService dashboardService;
    @Autowired
    OnlineSessionDAO onlineSessionDAO;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", systemConfig.getCopyrightYear());
        return "index";
    }


    // 图表首页
    @GetMapping("/dashboard/main")
    public String main(Model model) {

        model.addAttribute("version", systemConfig.getVersion());
        model.addAttribute("total", blogService.selectBlogCountByStatus(BlogConstants.BLOG_TOTAL));
        model.addAttribute("published", blogService.selectBlogCountByStatus(BlogConstants.BLOG_PUBLISHED));
        model.addAttribute("draft", blogService.selectBlogCountByStatus(BlogConstants.BLOG_DRAFT));
        model.addAttribute("garbage", blogService.selectBlogCountByStatus(BlogConstants.BLOG_GARBAGE));
        //在线用户数量
        model.addAttribute("onlineCount", onlineSessionDAO.getActiveSessions().size());
        //访客总人数
        model.addAttribute("totalCount", visitLogService.selectVisitLogTotalCount());
        //本月访客人数
        model.addAttribute("todayCount", visitLogService.selectVisitLogTodayCount());
        //放置最新消息
        model.addAttribute("logMessages", dashboardService.selectLogMessage());
        return "main";
    }


    @GetMapping("/dashboard/spiderData/list")
    @ResponseBody
    public AjaxResult spiderData() {
        List<BusinessCommonData> businessCommonData = dashboardService.selectSpiderData();
        return AjaxResult.success().put("data", businessCommonData);
    }

    @GetMapping("/dashboard/memJvmCpuData/list")
    @ResponseBody
    public AjaxResult memJvmCpuData() throws UnknownHostException {
        Server server = new Server();
        List<Double> data = server.getDashBoardData();
        return AjaxResult.success().put("data", data);
    }

    @GetMapping("/dashboard/visitCount/list")
    @ResponseBody
    public AjaxResult visitCount() {
        List<VisitCount> visitData = dashboardService.getVisitData();
        return AjaxResult.success().put("data", visitData);
    }

}