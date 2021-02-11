package com.taskmanager.taskmanager.service;

import java.util.List;

import com.taskmanager.taskmanager.entity.Projects;

public interface ProjectsService {

    List<Object[]> getProjectsList();
	
	Projects getProjectsDetail(Integer id);
	
	Projects addProjects(Projects projects);

	Projects getById(Integer id);
	
	Boolean delete(Integer id);
	
	void update(Projects projects);
}
