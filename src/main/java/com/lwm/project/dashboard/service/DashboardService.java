package com.lwm.project.dashboard.service;

import com.lwm.project.dashboard.domain.BusinessCommonData;
import com.lwm.project.dashboard.domain.LogMessage;
import com.lwm.project.dashboard.domain.VisitCount;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 08:10
 * @Description:
 */
public interface DashboardService {
    /**
     * 获取爬虫访问记录
     *
     * @return 爬虫数据实体类
     */
    List<BusinessCommonData> selectSpiderData();

    /**
     * 获取访问量的数据
     *
     * @return VisitCount实体类
     */
    List<VisitCount> getVisitData();

    List<LogMessage> selectLogMessage();
}