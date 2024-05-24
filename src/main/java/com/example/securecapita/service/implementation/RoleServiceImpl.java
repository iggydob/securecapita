package com.example.securecapita.service.implementation;

import com.example.securecapita.domain.Role;
import com.example.securecapita.repository.RoleRepository;
import com.example.securecapita.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository<Role> roleRepository;

    @Override
    public Role getRoteByUserId(Long userId) {
        return roleRepository.getRoleByUserId(userId);
    }
}
