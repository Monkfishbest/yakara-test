package com.john.codetest.controllers;

import com.john.codetest.ControllerUltilties.ContactUtils;
import com.john.codetest.Repositorys.ContactRepository;
import com.john.codetest.Repositorys.EmailCorrespondenceRecord;
import com.john.codetest.Repositorys.TemplateRepository;
import com.john.codetest.models.Contact;
import com.john.codetest.models.EmailRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRecordController {


    @Autowired
    ContactRepository contactRepository;

    @Autowired
    TemplateRepository templateRepository;

    @Autowired
    EmailCorrespondenceRecord emailCorrespondenceRecord;

    @PostMapping("/email-records")
    public ResponseEntity<EmailRecord> saveRecord(@RequestBody EmailRecord emailRecord) {

        Contact contactFromRequest = emailRecord.getContact();
        Contact contact = ContactUtils.handleContactInfoSave(contact, contactRepository);



        return ResponseEntity<>
    }


}
