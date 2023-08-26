package com.john.codetest.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="templates")
public class Template {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "template_name")
    private String templateName;

    @Column(name = "template_content")
    private String templateContent;

    @OneToMany(mappedBy = "template")
    private List<EmailRecord> emailRecord;

    public Template() {
    }

    public List<EmailRecord> getEmailRecord() {
        return emailRecord;
    }

    public void setEmailRecord(List<EmailRecord> emailRecord) {
        this.emailRecord = emailRecord;
    }

    public String getTemplateContent() {
        return templateContent;
    }



    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
