package io.qyi.mail.queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @program: queue
 * @description:
 * @author: 落叶随风
 * @create: 2021-02-17 17:11
 **/
@RestController
@RequestMapping("api/v1")
public class MailAPIController {
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("sendMail")
    void sendMain() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        message.setFrom("浅忆博客(系统)<server@curlc.com>");
        message.setTo("1007215773@qq.com");
        message.setSubject("HTML邮件");
        message.setText("<h1>Check attachment for image!</h1>", true);
        mailSender.send(mimeMessage);
    }
}
