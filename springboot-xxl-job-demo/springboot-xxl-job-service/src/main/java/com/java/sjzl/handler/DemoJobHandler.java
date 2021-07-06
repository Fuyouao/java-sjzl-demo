package com.java.sjzl.handler;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;



/**
 * @author Java升级之路
 * @description
 * @date 2021/7/4
 */

@Component
public class DemoJobHandler {

    static int count = 0;

    @XxlJob("demoJobHandler")
    public void execute(String param) throws Exception {
        System.out.println("hello,demoJobHandler执行job任务"+ count++);
    }
}
