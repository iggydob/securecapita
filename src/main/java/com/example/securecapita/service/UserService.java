package com.example.securecapita.service;

import com.example.securecapita.domain.User;
import com.example.securecapita.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);

}
