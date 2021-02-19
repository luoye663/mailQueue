package io.qyi.mail.queue.controller;

import io.qyi.mail.queue.service.IMailService;
import io.qyi.mail.queue.service.QueueService;
import io.qyi.mail.queue.service.bean.MailMsg;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

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
    IMailService mailService;

    @Value("${token}")
    String token_c;
    @RequestMapping("sendMail")
    public String sendMain(@RequestBody MailMsg mailMsgArg, String token) throws MessagingException {
        System.out.println(mailMsgArg.toString());
        if (StringUtils.isBlank(token)) {
            return "token is not null!";
        }
        if (!token_c.equals(token)) {
            return "token error!";
        }
        if (StringUtils.isBlank(mailMsgArg.getFrom())) {
            return "mail from is null";
        }
        if (StringUtils.isBlank(mailMsgArg.getTo())) {
            return "mail from to is null";
        }
        if (StringUtils.isBlank(mailMsgArg.getSubject())) {
            return "mail Subject is null";
        }
        if (StringUtils.isBlank(mailMsgArg.getText())) {
            return "mail text is null";
        }
        QueueService.getQueue().offer(mailMsgArg);
        return "ok";
    }
}
