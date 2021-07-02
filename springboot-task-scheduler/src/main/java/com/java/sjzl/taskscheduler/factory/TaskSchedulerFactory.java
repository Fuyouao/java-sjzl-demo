package com.java.sjzl.taskscheduler.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author Java升级之路
 * @description 自定义的工厂类  创建job实例并将其纳入到Spring容器的管理之中
 * @date 2021/7/1
 */
@Component
public class TaskSchedulerFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    protected Object creatJobInstance(TriggerFiredBundle bundle) throws Exception {
        //首先，调用父类的方法创建好quartz所需要的实例
        Object jobInstance = super.createJobInstance(bundle);
        //然后，使用BeanFactory为创建好的Job实例进行属性自动装配，并将其纳入到Spring容器的管理之中
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
