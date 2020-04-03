package com.lwm.project.dashboard.service.impl;

import com.lwm.common.utils.DateUtils;
import com.lwm.project.dashboard.domain.BusinessCommonData;
import com.lwm.project.dashboard.domain.LogMessage;
import com.lwm.project.dashboard.domain.VisitCount;
import com.lwm.project.dashboard.service.DashboardService;
import com.lwm.project.log.jobLog.domain.JobLog;
import com.lwm.project.log.jobLog.mapper.JobLogMapper;
import com.lwm.project.log.logininfor.mapper.LogininforMapper;
import com.lwm.project.log.operlog.domain.OperLog;
import com.lwm.project.log.operlog.mapper.OperLogMapper;
import com.lwm.project.log.visitorLog.domain.VisitLog;
import com.lwm.project.log.visitorLog.mapper.VisitLogMapper;
import com.lwm.project.system.dict.mapper.DictDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 08:12
 * @Description:
 */
@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    VisitLogMapper visitLogMapper;
    @Autowired
    OperLogMapper operLogMapper;
    @Autowired
    LogininforMapper logininforMapper;
    @Autowired
    JobLogMapper jobLogMapper;
    @Autowired
    DictDataMapper dictDataMapper;


    @Override
    public List<BusinessCommonData> selectSpiderData() {
        return visitLogMapper.selectSpiderData();
    }

    @Override
    public List<VisitCount> getVisitData() {
        List<String> pastDaysList = DateUtils.getPastDaysList(7);
        List<VisitCount> visitCounts = new ArrayList<>();
        for (String date : pastDaysList) {
            Integer visitorCountByVisitTime = visitLogMapper.selectVisitCountByCreateTime(date);
            VisitCount visitCount = new VisitCount();
            visitCount.setDate(date);
            visitCount.setValue(visitorCountByVisitTime);
            visitCounts.add(visitCount);
        }
        return visitCounts;
    }

    @Override
    public List<LogMessage> selectLogMessage() {
        List<LogMessage> messages = new ArrayList<>();
        //登录日志
        List<LogMessage> logMessages = logininforMapper.selectLoginInforData();
        if (logMessages != null && logMessages.size() != 0) {
            for (LogMessage logMessage : logMessages) {
                LogMessage temp = new LogMessage();
                temp.setDateStr(DateUtils.showTime(logMessage.getDate()));
                temp.setDate(logMessage.getDate());
                temp.setMessage(logMessage.getMessage() + " 登录了系统");
                messages.add(temp);
            }
        }
        //操作日志
        List<OperLog> operLogs = operLogMapper.selectOperLogData();
        if (operLogs != null && operLogs.size() != 0) {
            for (OperLog operLog : operLogs) {
                LogMessage temp = new LogMessage();
                temp.setDateStr(DateUtils.showTime(operLog.getOperTime()));
                temp.setDate(operLog.getOperTime());
                String sys_oper_type = dictDataMapper.selectDictLabel("sys_oper_type", operLog.getBusinessType().toString());
                temp.setMessage(operLog.getOperName() + " 对 " + operLog.getTitle() + " 进行了 " + sys_oper_type + " 操作");
                messages.add(temp);
            }
        }
        //访问日志
        List<VisitLog> visitLogs = visitLogMapper.selectVisitData();
        if (visitLogs != null && visitLogs.size() != 0) {
            for (VisitLog visitLog : visitLogs) {
                LogMessage temp = new LogMessage();
                temp.setDate(visitLog.getCreateTime());
                temp.setDateStr(DateUtils.showTime(visitLog.getCreateTime()));
                temp.setMessage(visitLog.getIpAddr() + " 访问了 " + visitLog.getTitle() + " 模块");
                messages.add(temp);
            }
        }
        //调度日志
        List<JobLog> jobLogs = jobLogMapper.selectJobData();
        for (JobLog jobLog : jobLogs) {
            LogMessage temp = new LogMessage();
            temp.setDateStr(DateUtils.showTime(jobLog.getCreateTime()));
            temp.setDate(jobLog.getCreateTime());
            temp.setMessage(jobLog.getJobName() + " 启动运行");
            messages.add(temp);
        }
        Collections.sort(messages, (logMessage1, logMessage2) -> {
            long time = logMessage1.getDate().getTime() - logMessage2.getDate().getTime();
            if (time < 0) {
                return 1;
            } else if (time > 0) {
                return -1;
            } else {
                return 0;
            }
        });
        return messages;
    }

}