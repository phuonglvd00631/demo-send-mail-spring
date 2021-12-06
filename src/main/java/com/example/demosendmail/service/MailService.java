package com.example.demosendmail.service;

import com.example.demosendmail.dto.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dto, String templateName) throws MessagingException;
}
