package io.qyi.mail.queue.service;

import io.qyi.mail.queue.service.bean.MailMsg;

import javax.mail.MessagingException;

/**
 * @program: queue
 * @description:
 * @author: 落叶随风
 * @create: 2021-02-18 08:37
 **/
public interface IMailService {
    /**
     * 
     * @param mailMsg: 邮件内容，支持html
     * @Author: 落叶随风
     * @Date: 2021/2/18  8:45
     * @Return: * @return: void
     */ 
    void sendMailHtml(MailMsg mailMsg) throws MessagingException;
}
