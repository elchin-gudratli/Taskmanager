package com.taskmanager.taskmanager.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Tasks;

import com.taskmanager.taskmanager.repository.TasksRepository;

@Transactional
@Service
public class TasksServiceImpl {
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
	
	
}
