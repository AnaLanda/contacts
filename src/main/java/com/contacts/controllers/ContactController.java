package com.contacts.controllers;

import com.contacts.model.Contact;
import com.contacts.model.dto.ContactRequestDto;
import com.contacts.model.dto.ContactResponseDto;
import com.contacts.service.ContactService;
import com.contacts.service.UserService;
import com.contacts.service.mapper.ContactMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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

    @GetMapping("/")
    public String getAllContacts(Model model) {
        List<ContactResponseDto> contacts = contactService.getAll().stream()
                .map(contactMapper::mapToDto)
                .collect(Collectors.toList());
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/contact/create")
    public String createContact(Model model) {
        ContactRequestDto contact = new ContactRequestDto();
        model.addAttribute("contact", contact);
        return "new-contact";
    }

    @PostMapping("/contact/save")
    public String addContact(@ModelAttribute ContactRequestDto contactRequestDto,
                             Model model) {
        contactService.add(contactMapper.mapToContact(contactRequestDto));
        return "redirect:/";
    }

    @GetMapping("/contact/edit/{email}")
    public String editContact(@PathVariable("email") String email, Model model) {
        ContactResponseDto contact = contactMapper.mapToDto(contactService.findByEmail(email));
        model.addAttribute("contact", contact);
        return "update-contact";
    }

    @PostMapping("/contact/update/{email}")
    public String updateContact(@PathVariable("email") String email,
                                ContactRequestDto contactRequestDto, Model model) {
        Contact contact = contactService.findByEmail(email);
        contactService.update(contact, contactRequestDto);
        return "redirect:/";
    }

    @GetMapping("/contact/delete/{email}")
    public String deleteContact(@PathVariable("email") String email,
                                ContactRequestDto contactRequestDto, Model model) {
        Contact contact = contactService.findByEmail(email);
        contactService.delete(contact);
        return "redirect:/";
    }
}
