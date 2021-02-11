package com.taskmanager.taskmanager.payload;

import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.repository.UsersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("mySecurityService")
public class MySecurityService {
    private final  UsersRepository usersRepository;

    public MySecurityService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean hasPermission(Authentication authentication, String roleName) {
        UserDetails ud = (UserDetails)authentication.getPrincipal();
        Optional<Users> users = usersRepository.findByUsername(ud.getUsername());
        return users.filter(value -> value.getRoles().stream().filter(role -> role.getRoleName().contains(roleName)).count() > 0).isPresent();
    }
}