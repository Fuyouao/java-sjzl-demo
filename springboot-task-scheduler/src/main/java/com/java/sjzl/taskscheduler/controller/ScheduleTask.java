package com.java.sjzl.taskscheduler.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Java升级之路
 * @description @Scheduled注解方式创建
 * @date 2021/7/2
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {

    //@Scheduled(cron = "0/5 * * * * ?")  //3.添加定时任务
    //@Scheduled(fixedRate=5000)        //或直接指定时间间隔，例如：5秒
    private void configureTasks() {
        System.out.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

}
