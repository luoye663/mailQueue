package io.qyi.mail.queue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class QueueApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

	@Test
	void contextLoads() throws MessagingException {
        sendMain();
	}
	@Test
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
