package com.john.codetest.controllers;

import com.john.codetest.Repositorys.TemplateRepository;
import com.john.codetest.models.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TemplatesController {

    @Autowired
    TemplateRepository templateRepository;

    @GetMapping("/templates")
    public ResponseEntity<List<Template>> getTemplates(){
        List<Template> templates = templateRepository.findAll();
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }
}
