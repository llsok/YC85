package com.yc.C85S3PlySpringBoot.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
    // 从Spring的配置文件中获取一个配置
    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 	发送邮件
     * @param to  		接受者邮箱地址
     * @param subject	主题
     * @param content	内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
