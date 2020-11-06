package com.contacts.service;

import com.contacts.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
