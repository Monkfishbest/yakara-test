package com.john.codetest.ControllerUltilties;

import com.john.codetest.models.Contact;
import com.john.codetest.models.Template;

public class EmailFormWrapper {

    private Contact contact;
    private Template template;

    public EmailFormWrapper(Contact contact, Template template) {
        this.contact = contact;
        this.template = template;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
