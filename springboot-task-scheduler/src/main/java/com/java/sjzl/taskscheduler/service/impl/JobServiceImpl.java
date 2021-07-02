package com.java.sjzl.taskscheduler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.sjzl.taskscheduler.constans.JobConstant;
import com.java.sjzl.taskscheduler.entity.Job;
import com.java.sjzl.taskscheduler.mapper.JobMapper;
import com.java.sjzl.taskscheduler.service.JobService;
import com.java.sjzl.taskscheduler.util.ScheduleUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定时任务表 服务实现类
 * @Author Java升级之路
 * @return
 **/
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createJob(Job job) {
        job.setStatus(JobConstant.JOB_STATUS_PAUSE);
        super.save(job);
        ScheduleUtil.create(job.getId(), job);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void pauseJob(Long id) {
        Job job = this.checkJobExist(id);
        job.setStatus(JobConstant.JOB_STATUS_PAUSE);
        super.updateById(job);
        ScheduleUtil.pause(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void resumeJob(Long id) {
        Job job = this.checkJobExist(id);
        job.setStatus(JobConstant.JOB_STATUS_RUNNING);
        super.updateById(job);
        ScheduleUtil.resume(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateJob(Job job) {
        job.setStatus(JobConstant.JOB_STATUS_RUNNING);
        super.updateById(job);
        ScheduleUtil.update(job.getId(), job);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteJob(Long id) {
        super.removeById(id);
        ScheduleUtil.delete(id);
    }

    public Job checkJobExist(Long id) {
        Job job = super.getById(id);
        if (job == null) {
            throw new RuntimeException("不存在的任务ID");
        }
        return job;
    }
}
