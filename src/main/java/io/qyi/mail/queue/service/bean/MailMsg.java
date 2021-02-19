package io.qyi.mail.queue.service.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @program: queue
 * @description:
 * @author: 落叶随风
 * @create: 2021-02-18 10:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailMsg {
    private String from;
    private String to;
    private String subject;
    private String text;
}
