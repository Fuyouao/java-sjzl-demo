package com.java.sjzl.taskscheduler.config;

import com.java.sjzl.taskscheduler.factory.TaskSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Java升级之路
 * @description  定时任务配置
 * @date 2021/7/1
 */
/*@Configuration
public class SchedulerConfig {

    @Autowired
    private TaskSchedulerFactory springJobFactory;

    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
        // 创建Scheduler的工厂
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJobFactory(springJobFactory);

        // quartz参数
        factory.setQuartzProperties(this.convertProp());
        factory.setSchedulerName("JavaSjzlScheduler");
        // 延时启动 应用启动30秒后
        factory.setStartupDelay(30);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 可选，QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        factory.setAutoStartup(true);

        return factory;
    }

    private Properties convertProp() {
        // quartz参数,也可以写在配置文件里
        Properties prop = new Properties();

        // 实例名字 #默认或是自己改名字都行
        prop.put("org.quartz.scheduler.instanceName", "JavaSjzlScheduler");
        // #如果使用集群，instanceId必须唯一，设置成AUTO
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        // 线程池配置
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        // 并发个数
        prop.put("org.quartz.threadPool.threadCount", "10");
        // # 设置工作者线程的优先级（最大值10，最小值1，常用值5）
        prop.put("org.quartz.threadPool.threadPriority", "5");
        // JobStore配置 #存储方式使用JobStoreTX，也就是数据库
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        // 集群配置
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");

        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
        // #数据库中quartz表的表名前缀
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");

        return prop;
    }
}*/
