package com.taskmanager.taskmanager.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.repository.UsersRepository;
import com.taskmanager.taskmanager.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UsersRepository users_repository;
	
	@SuppressWarnings("unused")
	private final ModelMapper modelMapper;
	
	public UsersServiceImpl(UsersRepository users_repository,ModelMapper modelMapper) {
		this.users_repository = users_repository;
		this.modelMapper = modelMapper;
		
	}
	

	@Override
	public List<Object[]> getUsersList() {
		List<Object[]> liste = users_repository.getUsersList();
		return liste;
	}


	@Override
	public Users getUserDetail(Integer id) {
		return users_repository.getUserDetail(id);
	}
	
	

	



	

}
