package com.java.sjzl.taskscheduler.controller;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Java升级之路
 * @description 使用TimerTask创建定时任务
 * @date 2021/7/2
 */
public class JobTimerTask {

    static long count = 0;
    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                System.out.println(count);
            }
        };
        //创建timer对象设置间隔时间
        Timer timer = new Timer();
        // 间隔天数
        long delay = 0;
        // 间隔毫秒数
        long period = 1000;
        timer.scheduleAtFixedRate(timerTask, delay, period);
    }
}
