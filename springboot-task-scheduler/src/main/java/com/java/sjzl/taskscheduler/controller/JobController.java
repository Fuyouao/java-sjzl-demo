package com.java.sjzl.taskscheduler.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.java.sjzl.taskscheduler.entity.Job;
import com.java.sjzl.taskscheduler.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 定时任务控制层
 * @Author Java升级之路
 **/
@Slf4j
@RestController
@RequestMapping(value = "schedule/job")
public class JobController {

    @Autowired
    private JobService jobService;


    /**
     * 添加定时任务
     * @param job 任务
     */
    @PostMapping(value = "add")
    public R add(@RequestBody Job job) {
        jobService.createJob(job);
        return R.ok(job);
    }

    /**
     * 暂停定时任务
     * @param id 任务ID
     */
    @PostMapping(value = "pause/{id}")
    public R pause(@PathVariable Long id) {
        jobService.pauseJob(id);
        return R.ok(null);
    }

    /**
     * 恢复定时任务
     * @param id 任务ID
     */
    @PostMapping(value = "resume/{id}")
    public R resume(@PathVariable Long id) {
        jobService.resumeJob(id);
        return R.ok(null);
    }

    /**
     * 更新定时任务
     * @param job 任务
     */
    @PostMapping(value = "update")
    public R update(@RequestBody Job job) {
        jobService.updateJob(job);
        return R.ok(job);
    }

    /**
     * 删除定时任务
     * @param id 任务ID
     */
    @PostMapping(value = "delete/{id}")
    public R delete(@PathVariable Long id) {
        jobService.deleteJob(id);
        return R.ok(null);
    }

}

