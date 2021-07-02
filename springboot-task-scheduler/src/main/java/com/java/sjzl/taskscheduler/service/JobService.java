package com.java.sjzl.taskscheduler.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.sjzl.taskscheduler.entity.Job;


/**
 *
 * @Author Java升级之路
 **/
public interface JobService extends IService<Job> {


    void createJob(Job job);

    void pauseJob(Long id);

    void resumeJob(Long id);

    void updateJob(Job job);

    void deleteJob(Long id);


}
