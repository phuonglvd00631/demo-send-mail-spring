package com.example.demosendmail.service;

import com.example.demosendmail.Utils.DataUtils;
import com.example.demosendmail.dto.ClientSdi;
import com.example.demosendmail.dto.DataMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    MailService mailService;

    @Override
    public Boolean create(ClientSdi sdi) {
        try {
            DataMailDTO dataMail = new DataMailDTO();

            dataMail.setTo(sdi.getEmail());
            dataMail.setSubject("Xác nhận tạo thông tin khách hàng.");

            Map<String, Object> props = new HashMap<>();
            props.put("name", sdi.getName());
            props.put("username", sdi.getUsername());
            props.put("password", 123);
            dataMail.setProps(props);
            System.out.println(sdi.getUsername());
            mailService.sendHtmlMail(dataMail, "client");
            return true;
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
        return false;
    }
}
