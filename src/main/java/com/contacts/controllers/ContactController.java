package com.contacts.controllers;

import com.contacts.model.Role;
import com.contacts.model.User;
import com.contacts.model.dto.ContactRequestDto;
import com.contacts.model.dto.ContactResponseDto;
import com.contacts.service.ContactService;
import com.contacts.service.UserService;
import com.contacts.service.mapper.ContactMapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;
    private final ContactMapper contactMapper;
    private final UserService userService;

    public ContactController(ContactService contactService,
                             ContactMapper contactMapper, UserService userService) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
        this.userService = userService;
    }

    @PostMapping("/create")
    public void addContact(@RequestBody ContactRequestDto contactRequestDto) {
        contactService.add(contactMapper.mapToContact(contactRequestDto));
    }

    @PostMapping("/edit")
    public void editContact(@RequestBody ContactRequestDto contactRequestDto) {
        contactService.update(contactMapper.mapToContact(contactRequestDto));
    }

    @GetMapping("/all")
    public String getAllContacts(Model model) {
        List<ContactResponseDto> contacts = contactService.getAll().stream()
                .map(contactMapper::mapToDto)
                .collect(Collectors.toList());
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
}
