package com.lwm.framework.shiro.session;

import com.lwm.common.utils.IpUtils;
import com.lwm.common.utils.ServletUtils;
import com.lwm.common.utils.StringUtils;
import com.lwm.project.monitor.online.domain.OnlineSession;
import com.lwm.project.monitor.online.domain.UserOnline;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: guya
 * @Date: 2020/3/21 08:35
 * @Description:
 */
@Component
public class OnlineSessionFactory implements SessionFactory {

    public Session createSession(UserOnline userOnline) {
        OnlineSession onlineSession = userOnline.getSession();
        if (StringUtils.isNotNull(onlineSession) && onlineSession.getId() == null) {
            onlineSession.setId(userOnline.getSessionId());
        }
        return userOnline.getSession();
    }

    @Override
    public Session createSession(SessionContext initData) {
        OnlineSession session = new OnlineSession();
        if (initData != null && initData instanceof WebSessionContext) {
            WebSessionContext sessionContext = (WebSessionContext) initData;
            HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
            if (request != null) {
                UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                session.setHost(IpUtils.getIpAddr(request));
                session.setBrowser(browser);
                session.setOs(os);
            }
        }
        return session;
    }
}
