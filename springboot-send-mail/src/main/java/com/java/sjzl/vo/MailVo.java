package com.java.sjzl.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Java升级之路
 * @description
 * @date 2021/4/29
 */
@Data
public class MailVo implements Serializable{

    private static final long serialVersionUID = 1409009426163204670L;

    /**
     * 发件人邮箱
     */
    private String from;
    /**
     * 收件人邮箱，多个邮箱以“,”分隔
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 正文内容
     */
    private String text;
    /**
     * 发送时间
     */
    private Date sentDate;
    /**
     * 抄送人邮箱，多个邮箱以“,”分隔
     */
    private String cc;
    /**
     * 秘密抄送人邮箱，多个邮箱以“,”分隔
     */
    private String bcc;
    /**
     * 发送状态
     */
    private String status;
    /**
     * 错误信息
     */
    private String error;

    /**
     * 附件
     */
    @JsonIgnore
    private MultipartFile[] multipartFiles;
}
