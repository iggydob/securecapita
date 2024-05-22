package com.example.securecapita.service.implementation;

import com.example.securecapita.domain.User;
import com.example.securecapita.dto.UserDTO;
import com.example.securecapita.dtomapper.UserDTOMapper;
import com.example.securecapita.repository.UserRepository;
import com.example.securecapita.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }

}
