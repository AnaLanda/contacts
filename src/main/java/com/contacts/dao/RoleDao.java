package com.contacts.dao;

import com.contacts.model.Role;

import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
