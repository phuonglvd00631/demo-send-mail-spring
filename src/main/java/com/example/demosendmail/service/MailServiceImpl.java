package com.example.demosendmail.service;

import com.example.demosendmail.dto.DataMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService{
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void sendHtmlMail(DataMailDTO dto, String templateName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        Context context = new Context();
        context.setVariables(dto.getProps());

        String html = templateEngine.process(templateName, context);
        // path file dinh kem
        String path = "C:/Users/ADMIN/Desktop/template.docx";
        // Attachment
        FileSystemResource file1 = new FileSystemResource(new File(path));
        helper.addAttachment("test.docx", file1);


        helper.setTo(dto.getTo());
        helper.setSubject(dto.getSubject());
        helper.setText(html, true);

        mailSender.send(message);
    }
}
