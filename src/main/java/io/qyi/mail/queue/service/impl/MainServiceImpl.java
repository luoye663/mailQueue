package io.qyi.mail.queue.service.impl;

import io.qyi.mail.queue.service.IMailService;
import io.qyi.mail.queue.service.bean.MailMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @program: queue
 * @description:
 * @author: 落叶随风
 * @create: 2021-02-18 08:46
 **/
@Service
public class MainServiceImpl implements IMailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMailHtml(MailMsg msg) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        message.setFrom(msg.getFrom());
        message.setTo(msg.getTo());
        message.setSubject(msg.getSubject());
        message.setText(msg.getText(), true);
        mailSender.send(mimeMessage);
    }


}
