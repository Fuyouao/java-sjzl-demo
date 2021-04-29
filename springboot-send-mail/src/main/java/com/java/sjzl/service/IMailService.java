package com.java.sjzl.service;

import com.java.sjzl.vo.MailVo;

/**
 * @author Java升级之路
 * @description
 * @date 2021/4/29
 */
public interface IMailService {

    /**
     *  获取发件人
     **/
    String getMailSendFrom();

    /**
     * 发送邮件
     **/
    MailVo sendMail(MailVo mailVo);
}
