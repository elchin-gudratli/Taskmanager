package com.taskmanager.taskmanager.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.repository.UsersRepository;
import com.taskmanager.taskmanager.service.UsersService;

@Transactional
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
	public Users getById(Integer id) {
		Users p=users_repository.getOne(id);	
		return p;
	}
	

	@Override
	public Users getUserDetail(Integer id) {
		return users_repository.getUserDetail(id);
	}

	public Users addUsers(Users users) {
		return users_repository.save(users);
	}
	public Users UsersSearch(Integer usersid) {
		return users_repository.getOne(usersid);
	}
	
	@Override
	public Boolean delete(Integer id) {
		 users_repository.deleteById(id);
	        return true;
	}
	@Override
	public void update(Users users) {
		/*System.out.println(users.getUserid());
		System.out.println(users.getName());
	     if(users.getUserid()==null)
	        {
	            throw  new IllegalArgumentException("hata");
	        }
	       
	       users_repository.update(users.getName(),users.getUserid());*/
		users_repository.save(users);
	    
	}

	



}
