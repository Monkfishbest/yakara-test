package com.john.codetest.ControllerUltilties;

import com.john.codetest.models.EmailRecord;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public static void sendTemplateEmail(EmailRecord emailRecord, JavaMailSender javaMailSender) throws MailException  {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRecord.getContact().getEmail());
        message.setSubject("You have a new message from Yakara");
        String emailBody = String.format("Hello %s, this is a message from Yakara\n\n %s", emailRecord.getContact().getName(), emailRecord.getTemplate().getTemplateContent());
        message.setText(emailBody);

        javaMailSender.send(message);
    }

}
