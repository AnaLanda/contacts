package com.contacts.dao;

import com.contacts.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
