package com.contacts.service;

import com.contacts.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User findById(Long id);
}
