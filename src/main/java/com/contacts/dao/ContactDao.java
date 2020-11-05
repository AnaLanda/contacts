package com.contacts.dao;

import com.contacts.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    Contact add(Contact contact);

    Optional<Contact> findByEmail(String email);

    Optional<Contact> findById(Long id);

    List<Contact> getAll();

    Contact update(Contact contact);
}
