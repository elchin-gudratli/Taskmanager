package com.taskmanager.taskmanager.service.impl;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.repository.UsersRepository;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
    private UsersRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        System.out.println("User from username " + user.getUsername());
        return UserDetailsImpl.builder(user);
    }


    @Transactional
    public Users loadUsernameBy(String username){
        Users users = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return users;

    }
}
