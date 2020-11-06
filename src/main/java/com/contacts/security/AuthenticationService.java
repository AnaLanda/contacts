package com.contacts.security;

import com.contacts.model.Role;
import com.contacts.model.User;
import java.util.Set;

public interface AuthenticationService {
    User register(String email, String password, Set<Role> roles);
}
