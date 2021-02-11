package com.taskmanager.taskmanager.service;

import java.util.List;

import org.hibernate.Session;
import com.taskmanager.taskmanager.entity.Users;

public interface UsersService {
	
	List<Object[]> getUsersList();
	
	Users getById(Long id);
	
	Users getUserDetail(Long id);

	Users addUsers(Users users);

	Boolean delete(Long id);
	
	void update(Users users);
	
	
}
