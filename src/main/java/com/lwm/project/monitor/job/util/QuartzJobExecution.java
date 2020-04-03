package com.lwm.project.monitor.job.util;

import com.lwm.project.monitor.job.domain.Job;
import org.quartz.JobExecutionContext;

/**
 * @Auther: guya
 * @Date: 2020/3/21 20:48
 * @Description:  定时任务处理（允许并发执行）
 */
public class QuartzJobExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, Job job) throws Exception {
        JobInvokeUtil.invokeMethod(job);
    }
}