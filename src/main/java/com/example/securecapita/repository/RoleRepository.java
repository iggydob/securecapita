package com.example.securecapita.repository;

import com.example.securecapita.domain.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role> {

    T create(T data);

    Collection<T> list();

    T get(Long id);

    T update(T data);

    Boolean delete(Long id);

    /* More Complex Operations */
    void addRoleToUser(Long userId, String roleName);

    Role getRoleByUserId(Long userId);

    Role getRoleByUserEmail(String email);


    void updateUserRole(Long userId, String roleName);
}
