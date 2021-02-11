package com.taskmanager.taskmanager.service;

import java.util.List;

import com.taskmanager.taskmanager.entity.Tasks;

public interface TasksService {

	List<Object[]> getTasksList();
	
	Tasks getTasksDetail(Integer id);
    
	Tasks addTasks(Tasks tasks);
	
	Tasks getById(Integer id);
	
	Boolean delete(Integer id);
	
	void update(Tasks tasks);
}
