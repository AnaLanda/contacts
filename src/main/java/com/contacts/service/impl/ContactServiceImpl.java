package com.contacts.service.impl;

import com.contacts.dao.ContactDao;
import com.contacts.model.Contact;
import com.contacts.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactDao contactDao;

    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Contact add(Contact contact) {
        return contactDao.add(contact);
    }

    @Override
    public Contact findByEmail(String email) {
        return contactDao.findByEmail(email).get();
    }

    @Override
    public Contact findById(Long id) {
        return contactDao.findById(id).get();
    }

    @Override
    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.update(contact);
    }
}
