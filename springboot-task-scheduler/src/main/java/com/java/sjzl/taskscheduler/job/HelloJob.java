package com.java.sjzl.taskscheduler.job;

import com.java.sjzl.taskscheduler.constans.JobConstant;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Java升级之路
 * @description 测试任务调度类
 * @date 2021/7/1
 */
@Slf4j
@Component
public class HelloJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获得传入的参数
        Object params = jobExecutionContext.getMergedJobDataMap().get(JobConstant.JOB_MAP_KEY);
        log.info("helloJob is running params={}, time:{}", params, new Date());
    }
}
