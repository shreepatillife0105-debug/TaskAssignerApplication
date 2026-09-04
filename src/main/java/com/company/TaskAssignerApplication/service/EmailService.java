package com.company.TaskAssignerApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendTaskEmail(String toEmail, String internName, String taskTitle, String description) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("New Task Assigned: " + taskTitle);
        message.setText(
            "Hello " + internName + ",\n\n" +
            "You have been assigned a new task:\n\n" +
            "Title       : " + taskTitle + "\n" +
            "Description : " + description + "\n\n" +
            "Please complete it on time.\n\n" 
        );
        mailSender.send(message);
    }

}
