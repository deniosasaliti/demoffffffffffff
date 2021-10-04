package com.example.demo.service;

import com.example.demo.utilPojo.NotificationEmail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Service
public class MailService {

    private final JavaMailSender sender;

    private final Configuration freemarkerConfig;

    public MailService(@Qualifier("getFreeMarkerConfiguration") Configuration freemarkerConfig, JavaMailSender sender) {
        this.freemarkerConfig = freemarkerConfig;
        this.sender = sender;
    }

    @Async
    public void sendEmail(NotificationEmail mail, Map<String,Object> model) throws Exception {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);




        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");

        Template t = freemarkerConfig.getTemplate("emailTemplate.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);


        helper.setTo(mail.getRecipient());
        helper.setText(text,true);
        helper.setSubject(mail.getSubject());

        sender.send(message);
    }



}
