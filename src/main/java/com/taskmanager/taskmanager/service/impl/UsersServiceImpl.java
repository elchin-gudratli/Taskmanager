package com.taskmanager.taskmanager.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.taskmanager.taskmanager.entity.RoleType;
import com.taskmanager.taskmanager.entity.Role;
import com.taskmanager.taskmanager.payload.UserRequest;
import com.taskmanager.taskmanager.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.exception.UsernameAlreadyExistsException;
import com.taskmanager.taskmanager.repository.UsersRepository;
import com.taskmanager.taskmanager.service.UsersService;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @SuppressWarnings("unused")
    private final ModelMapper modelMapper;

    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;

    }


    @Override
    public List<Object[]> getUsersList() {
        List<Object[]> usersList = usersRepository.getUsersList();
        return usersList;
    }

    @Override
    public Users getById(Long id) {
        Users p = usersRepository.getOne(id);
        return p;
    }


    @Override
    public Users getUserDetail(Long id) {
        return usersRepository.getUserDetail(id);
    }

	@Override
	public Users addUsers(Users users) {
        return usersRepository.save(users);
    }

    public Users usersSearch(Long usersid) {
        return usersRepository.getOne(usersid);
    }

    @Override
    public Boolean delete(Long id) {
        usersRepository.deleteById(id);
        return true;
    }

    @Override
    public void update(Users users) {
        usersRepository.save(users);
    }


    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users saveUser(UserRequest registerRequest) {
        Users newUser =null;
        try {
            newUser = new Users();
            newUser.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));

            newUser.setUsername(registerRequest.getUsername());
            newUser.setEmail(registerRequest.getEmail());
            newUser.setName(registerRequest.getName());
            newUser.setSurname(registerRequest.getSurname());

            Set<Role> defaultRoleSet = new HashSet<>();
            Role role;
            if(registerRequest.getRoles()==null || registerRequest.getRoles().isEmpty()) {
                role = roleRepository.findRoleByRoleName(RoleType.USER.name());
                defaultRoleSet.add(role);
            } else {
                for (String roleString:registerRequest.getRoles()) {
                    role = roleRepository.findRoleByRoleName(RoleType.valueOf(roleString).name());
                    defaultRoleSet.add(role);
                }
            }
            newUser.setRoles(defaultRoleSet);
            return userRepository.saveAndFlush(newUser);

        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newUser.getUsername() + "' already exists");
        }

    }


}
