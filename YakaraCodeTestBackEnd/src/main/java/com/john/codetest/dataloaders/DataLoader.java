package com.john.codetest.dataloaders;

import com.john.codetest.Repositorys.ContactRepository;
import com.john.codetest.Repositorys.EmailRecordRepository;
import com.john.codetest.Repositorys.TemplateRepository;
import com.john.codetest.models.Contact;
import com.john.codetest.models.EmailRecord;
import com.john.codetest.models.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    EmailRecordRepository emailRecordRepository;
    @Autowired
    ContactRepository contactRepository;


    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //  seeding database
        emailRecordRepository.deleteAll();
        templateRepository.deleteAll();
        contactRepository.deleteAll();

        List<EmailRecord> emailRecords = new ArrayList<>();

        Template template1 = new Template("Template 1", "Hello this is the first template \n We are writing to inform you etc", emailRecords);
        Template template2 = new Template("Template 2", "Hello this is the second template \n We are writing to inform you blah blah blah", emailRecords);
        Template template3 = new Template("Template 3", "Hello this is the third template \n We are writing to inform you testtestest", emailRecords);

        templateRepository.save(template1);
        templateRepository.save(template2);
        templateRepository.save(template3);

    }
}