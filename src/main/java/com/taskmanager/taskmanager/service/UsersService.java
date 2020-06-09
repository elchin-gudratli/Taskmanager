package com.taskmanager.taskmanager.service;

import java.util.List;

import com.taskmanager.taskmanager.entity.Users;

public interface UsersService {
	
	List<Object[]> getUsersList();
	
	Users getUserDetail(Integer id);

}
