package com.java.sjzl.taskscheduler.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Java升级之路
 * @description
 */
@Configuration
@MapperScan("com.java.sjzl.taskscheduler.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {


}
