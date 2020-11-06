package com.contacts.service;

import com.contacts.model.Contact;
import com.contacts.model.dto.ContactRequestDto;
import java.util.List;

public interface ContactService {
    Contact add(Contact contact);

    Contact findByEmail(String email);

    Contact findById(Long id);

    List<Contact> getAll();

    Contact update(Contact contact, ContactRequestDto dto);

    Contact delete(Contact contact);
}
