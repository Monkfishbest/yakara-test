package com.john.codetest.controllers;

import com.john.codetest.ControllerUltilties.ContactUtils;
import com.john.codetest.ControllerUltilties.EmailService;
import com.john.codetest.Repositorys.ContactRepository;
import com.john.codetest.Repositorys.EmailRecordRepository;
import com.john.codetest.models.Contact;
import com.john.codetest.models.EmailRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRecordController {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EmailRecordRepository emailRecordRepository;

    @PostMapping("/email-records")
    public ResponseEntity<?> saveRecord(@RequestBody EmailRecord emailRecord) {

        Contact contactFromRequest = emailRecord.getContact();
        if (!contactFromRequest.isValidContact()){
            return new ResponseEntity<>("Error: the contact details from the request where invalid", HttpStatus.BAD_REQUEST);
        }

        Contact contact = ContactUtils.handleSaveContactInfo(contactFromRequest, contactRepository);
        emailRecord.setContact(contact);

        try {
            EmailService.sendTemplateEmail(emailRecord, javaMailSender);
        } catch(MailException exception) {
            exception.printStackTrace();
            return new ResponseEntity<>("Error: Something went wrong when trying to send the email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        emailRecordRepository.save(emailRecord);

        return new ResponseEntity<>(emailRecord, HttpStatus.CREATED );
    }


}
