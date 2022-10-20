package com.example.demo.service;

import com.example.demo.utilPojo.NotificationEmail;

import java.util.Map;

public interface MailService {

   void sendEmail(NotificationEmail mail, Map<String,Object> model) throws Exception;
}
