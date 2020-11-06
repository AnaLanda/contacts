package com.contacts.service;

import com.contacts.model.Contact;
import com.contacts.model.Role;
import com.contacts.security.AuthenticationService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class InjectDataService {
    private final RoleService roleService;
    private final AuthenticationService authenticationService;
    private final ContactService contactService;

    public InjectDataService(RoleService roleService,
                             AuthenticationService authenticationService,
                             ContactService contactService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.contactService = contactService;
    }

    @PostConstruct
    public void injectData() {
        Role user = Role.of("USER");
        roleService.add(user);
        Role admin = roleService.add(Role.of("ADMIN"));
        authenticationService.register("admin@gmail.com", "1234", Set.of(admin));
        authenticationService.register("user@gmail.com", "1234", Set.of(user));
        Contact contact = new Contact();
        contact.setName("Nastia");
        contact.setEmail("stasia.melnyk@gmail.com");
        contactService.add(contact);
    }
}
