package com.taskmanager.taskmanager.service;

import java.util.List;

import org.hibernate.Session;
import com.taskmanager.taskmanager.entity.Users;

public interface UsersService {
	
	List<Object[]> getUsersList();
	
	Users getById(Integer id);
	
	Users getUserDetail(Integer id);

	Users addUsers(Users users);
	
	Boolean delete(Integer id);
	
	void update(Users users);
	
	

}
