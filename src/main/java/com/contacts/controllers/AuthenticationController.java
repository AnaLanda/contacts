package com.contacts.controllers;

import com.contacts.model.dto.UserRequestDto;
import com.contacts.security.AuthenticationService;
import com.contacts.service.RoleService;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RoleService roleService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    RoleService roleService) {
        this.authenticationService = authenticationService;
        this.roleService = roleService;
    }

    @PostMapping("/registration")
    public void register(@RequestBody @Valid UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword(),
                Set.of(roleService.getRoleByName("USER")));
    }
}
