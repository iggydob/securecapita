package com.example.securecapita.service;

import com.example.securecapita.domain.Role;

import java.util.Collection;

public interface RoleService {
    Role getRoteByUserId(Long userId);

    Collection<Role> getRoles();
}
