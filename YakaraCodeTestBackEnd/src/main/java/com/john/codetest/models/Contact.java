package com.john.codetest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;

@Entity
@Table(name="contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "contact")
    private List<EmailRecord> emailRecord;

    public Contact() {
    }

    public void normaliseFormInput(){
        this.email = this.email.trim();
        this.name = this.name.trim();
    }
    public boolean isValidContact(){

        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(this.email.trim()) && this.name.trim().length() > 1;
    }


    public List<EmailRecord> getEmailRecord() {
        return emailRecord;
    }

    public void setEmailRecord(List<EmailRecord> emailRecord) {
        this.emailRecord = emailRecord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
