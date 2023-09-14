package com.john.codetest.models;

import jakarta.persistence.*;

@Entity
@Table(name = "email_records")
public class EmailRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    public EmailRecord(Template template, Contact contact) {
        this.template = template;
        this.contact = contact;
    }

    public EmailRecord() {
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Template getTemplate() {
        return template;
    }


    public void setTemplate(Template template) {
        this.template = template;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
