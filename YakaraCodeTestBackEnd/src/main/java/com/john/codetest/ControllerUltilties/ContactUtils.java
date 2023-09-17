package com.john.codetest.ControllerUltilties;

import com.john.codetest.Repositorys.ContactRepository;
import com.john.codetest.models.Contact;

import java.util.Optional;

public class ContactUtils {

    public static Contact handleSaveContactInfo(Contact contact, ContactRepository contactRepository) {

        String emailAddress = contact.getEmail();
        Optional<Contact> existingContact = contactRepository.findByEmail(emailAddress);

        if (existingContact.isEmpty()) {
            contact.normaliseFormInput();
            contactRepository.save(contact);
            return contact;
        } else {
            return existingContact.get();
        }
    }


}
