package com.contacts.service.mapper;

import com.contacts.model.Contact;
import com.contacts.model.dto.ContactRequestDto;
import com.contacts.model.dto.ContactResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public ContactResponseDto mapToDto(Contact contact) {
        ContactResponseDto contactResponseDto = new ContactResponseDto();
        contactResponseDto.setId(contact.getId());
        contactResponseDto.setEmail(contact.getEmail());
        contactResponseDto.setFullName(contact.getFullName());
        contactResponseDto.setImage(contact.getImage());
        return contactResponseDto;
    }

    public Contact mapToContact(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        contact.setEmail(contactRequestDto.getEmail());
        contact.setFullName(contactRequestDto.getFullName());
        contact.setImage(contactRequestDto.getImage());
        return contact;
    }
}
