package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findRoleByUsers(String username);
    Role findRoleByRoleName(String roleName);
}
