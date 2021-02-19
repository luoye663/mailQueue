package io.qyi.mail.queue.config.queue;

import io.qyi.mail.queue.service.IMailService;
import io.qyi.mail.queue.service.QueueService;
import io.qyi.mail.queue.service.bean.MailMsg;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: queue
 * @description:
 * @author: 落叶随风
 * @create: 2021-02-18 10:12
 **/
@Configuration
public class queueConfig {

    private boolean IsThreadStatus;
    static ExecutorService service;

    @Autowired
    IMailService mailService;

    @PostConstruct
    private void init() {
        System.out.println("开启检测线程池");
        service = Executors.newFixedThreadPool(3);
        /*暂时不用线程池*/
        Thread thread = new Thread(new mailthread());
        IsThreadStatus = true;
        thread.start();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁队列线程池");
        service.shutdown();
        IsThreadStatus = false;
    }


    class mailthread implements Runnable {

        @Override
        public void run() {
            try {
                while (IsThreadStatus) {
                    while (!QueueService.getQueue().isEmpty()) {
                        System.out.println("队列有消息!");
                        MailMsg mailMsg = (MailMsg) QueueService.getQueue().poll();
                        System.out.println(mailMsg.toString());
                        mailService.sendMailHtml(mailMsg);
                        System.out.println("邮件发送完成!");
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
