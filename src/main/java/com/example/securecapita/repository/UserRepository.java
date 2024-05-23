package com.example.securecapita.repository;

import com.example.securecapita.domain.User;
import com.example.securecapita.dto.UserDTO;

import java.util.Collection;

public interface UserRepository<T extends User> {
    T create(T data);

    Collection<T> list(int page, int pageSize);

    T get(Long id);

    T update(T data);

    Boolean delete(Long id);

    User getUserByEmail(String email);

    void sendVerificationCode(UserDTO user);
}