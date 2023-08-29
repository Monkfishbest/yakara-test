package com.john.codetest.controllers;

import com.john.codetest.ControllerUltilties.ContactUtils;
import com.john.codetest.Repositorys.ContactRepository;
import com.john.codetest.Repositorys.EmailRecordRepository;
import com.john.codetest.models.Contact;
import com.john.codetest.models.EmailRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRecordController {


    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EmailRecordRepository emailRecordRepository;

    @PostMapping("/email-records")
    public ResponseEntity<EmailRecord> saveRecord(@RequestBody EmailRecord emailRecord) {

        Contact contactFromRequest = emailRecord.getContact();
        if (!contactFromRequest.isValidContact()){
            return new ResponseEntity<>(emailRecord, HttpStatus.BAD_REQUEST);
        }

        Contact contact = ContactUtils.handleContactInfoSave(contactFromRequest, contactRepository);

        emailRecord.setContact(contact);
        emailRecordRepository.save(emailRecord);

        return new ResponseEntity<>(emailRecord, HttpStatus.CREATED );
    }


}
