package com.contacts.service;

import com.contacts.model.Contact;

import java.util.List;

public interface ContactService {
    Contact add(Contact contact);

    Contact findByEmail(String email);

    Contact findById(Long id);

    List<Contact> getAll();

    Contact update(Contact contact);
}
