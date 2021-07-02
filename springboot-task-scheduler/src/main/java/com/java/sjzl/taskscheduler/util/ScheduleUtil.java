package com.java.sjzl.taskscheduler.util;


import com.java.sjzl.taskscheduler.constans.JobConstant;
import com.java.sjzl.taskscheduler.entity.Job;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author Java升级之路
 * @description 执行任务工具类
 * @date 2021/7/1
 */
public class ScheduleUtil {

    private final static String JOB_KEY = "JOB_";
    /**
     * 获取schedulerBean
     **/
    private final static Scheduler scheduler = SpringContextUtil.getBean(Scheduler.class);

    /**
     * 创建定时任务
     **/
    public static void create(Long jobId, Job job) {
        try {
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleUtil.getJobClass(job.getBean()).getClass())
                    .withIdentity(getJobKey(jobId))
                    .build();
            //表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron());
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(jobId))
                    .withSchedule(scheduleBuilder).build();
            // 传入参数
            jobDetail.getJobDataMap().put(JobConstant.JOB_MAP_KEY, job.getParams());
            scheduler.scheduleJob(jobDetail, trigger);

            // 默认创建时任务设置为暂停
            ScheduleUtil.pause(jobId);
        } catch (SchedulerException e) {
            throw new RuntimeException("创建定时任务失败");
        }
    }
    /**
     * 暂停定时任务
     **/
    public static void pause(Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RuntimeException("暂停定时任务失败");
        }
    }
    /**
     * 恢复启动定时任务
     **/
    public static void resume(Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RuntimeException("恢复启动定时任务失败");
        }
    }
    /**
     * 更新启动定时任务
     **/
    public static void update(Long jobId, Job job) {
        try {
            TriggerKey triggerKey = getTriggerKey(jobId);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 更新参数
            trigger.getJobDataMap().put(JobConstant.JOB_MAP_KEY, job.getParams());
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException("更新定时任务失败");
        }
    }
    /**
     * 删除定时任务
     **/
    public static void delete(Long jobId) {
        try {
            scheduler.pauseTrigger(getTriggerKey(jobId));
            scheduler.unscheduleJob(getTriggerKey(jobId));
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RuntimeException("删除定时任务失败");
        }
    }

    public static QuartzJobBean getJobClass(String classname) {
        return (QuartzJobBean) SpringContextUtil.getBean(classname);
    }
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(JOB_KEY + jobId);
    }

    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(JOB_KEY + jobId);
    }
}
