package com.taskmanager.taskmanager.service.impl;


import com.taskmanager.taskmanager.entity.Role;
import com.taskmanager.taskmanager.repository.RoleRepository;
import com.taskmanager.taskmanager.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

}
