package com.taskmanager.taskmanager.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Tasks;
import com.taskmanager.taskmanager.repository.TasksRepository;
import com.taskmanager.taskmanager.service.TasksService;

@Transactional
@Service
public class TasksServiceImpl implements TasksService{

private final TasksRepository tasks_repository;
	
	@SuppressWarnings("unused")
	private final ModelMapper modelMapper;
	
	public TasksServiceImpl(TasksRepository tasks_repository,ModelMapper modelMapper) {
		this.tasks_repository = tasks_repository;
		this.modelMapper = modelMapper;
		
	}

	public List<Object[]> getTasksList() {
		List<Object[]> liste =  tasks_repository.getTasksList();
		return liste;
		
	}

	@Override
	public Tasks getTasksDetail(Integer id) {
		return tasks_repository.getTasksDetail(id);
	}

	@Override
	public Tasks addTasks(Tasks tasks) {
		return tasks_repository.save(tasks);
	}
	
	public Tasks TasksSearch(Integer tasksid) {
		return tasks_repository.getOne(tasksid);
	}
	
	public void deleteTasks(Tasks tasks) {
		tasks_repository.delete(tasks);
	}

	@Override
	public Tasks getById(Integer id) {
        Tasks t=tasks_repository.getOne(id);
		return t;
	}
	

	@Override
	public Boolean delete(Integer id) {
		 tasks_repository.deleteById(id);
	        return true;
	}

	@Override
	public void update(Tasks tasks) {
		tasks_repository.save(tasks);
		
	}
	
	
}
