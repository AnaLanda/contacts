package com.contacts.service.impl;

import com.contacts.dao.ContactDao;
import com.contacts.model.Contact;
import com.contacts.model.dto.ContactRequestDto;
import com.contacts.service.ContactService;
import java.util.List;
import org.springframework.stereotype.Service;

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
    public Contact update(Contact contact, ContactRequestDto dto) {
        contact.setEmail(dto.getEmail());
        contact.setName(dto.getName());
        return contactDao.update(contact);
    }

    @Override
    public Contact delete(Contact contact) {
        return contactDao.delete(contact);
    }
}
