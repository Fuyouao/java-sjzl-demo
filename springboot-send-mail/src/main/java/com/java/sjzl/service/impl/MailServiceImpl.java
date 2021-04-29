package com.java.sjzl.service.impl;

import com.java.sjzl.service.IMailService;
import com.java.sjzl.vo.MailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author Java升级之路
 * @description
 * @date 2021/4/29
 */
@Service
public class MailServiceImpl implements IMailService{

    Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Override
    public String getMailSendFrom() {
        //获取配置的发件人
        return javaMailSender.getJavaMailProperties().getProperty("from");
    }

    @Override
    public MailVo sendMail(MailVo mailVo) {
        try {
            //先校验参数
            this.checkMialData(mailVo);
            //发送
            this.mimeSendMail(mailVo);
            return mailVo;
        } catch (Exception e) {
            logger.error("发送邮件失败:", e);
            mailVo.setStatus("fail");
            mailVo.setError(e.getMessage());
            return mailVo;
        }
    }

    private void checkMialData(MailVo mailVo) {
        if (!StringUtils.hasText(mailVo.getTo())) {
            throw new RuntimeException("收件人不能为空");
        } else if (!StringUtils.hasText(mailVo.getText())) {
            throw new RuntimeException("内容不能为空");
        } else if (!StringUtils.hasText(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
    }


    private void mimeSendMail(MailVo mailVo) {
        try {
            //使用JavaMail创建一个MimeMessage
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //创建MimeMessageHelper对象，用来添加发送信息
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            //赋值发送信息
            mimeMessageHelper.setFrom(this.getMailSendFrom());
            mimeMessageHelper.setTo(mailVo.getTo().split(","));
            mimeMessageHelper.setSubject(mailVo.getSubject());
            mimeMessageHelper.setText(mailVo.getText());
            if (StringUtils.hasText(mailVo.getCc())) {
                mimeMessageHelper.setCc(mailVo.getCc().split(","));
            }
            if (StringUtils.hasText(mailVo.getBcc())) {
                mimeMessageHelper.setCc(mailVo.getBcc().split(","));
            }
            if (mailVo.getMultipartFiles() != null) {
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    mimeMessageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }
            }
            if (mailVo.getSentDate() == null) {
                mailVo.setSentDate(new Date());
                mimeMessageHelper.setSentDate(mailVo.getSentDate());
            }

            javaMailSender.send(mimeMessageHelper.getMimeMessage());
            mailVo.setStatus("ok");
            logger.info("发送邮件成功：{}->{}", mailVo.getFrom(), mailVo.getTo());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
