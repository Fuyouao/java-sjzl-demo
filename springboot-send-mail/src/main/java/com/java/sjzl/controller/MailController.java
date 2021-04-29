package com.java.sjzl.controller;

import com.java.sjzl.service.IMailService;
import com.java.sjzl.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Java升级之路
 * @description
 * @date 2021/4/29
 */
@RestController
public class MailController {

    @Autowired
    private IMailService mailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        //指定返回页面名称
        ModelAndView mv = new ModelAndView("mail/sendMail");
        //设置返回值
        mv.addObject("from", mailService.getMailSendFrom());
        return mv;
    }

    @RequestMapping(value = "/mail/send", method = RequestMethod.POST)
    public MailVo sendMail(MailVo mailVo, MultipartFile[] files) {
        mailVo.setMultipartFiles(files);
        return mailService.sendMail(mailVo);
    }
}
