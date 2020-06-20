package com.taskmanager.taskmanager.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Projects;
import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.repository.ProjectsRepository;
import com.taskmanager.taskmanager.service.ProjectsService;

@Transactional
@Service
public class ProjectsServiceImpl implements ProjectsService{

	private final ProjectsRepository projects_repository;
	

	@SuppressWarnings("unused")
	private final ModelMapper modelMapper;
	
	public ProjectsServiceImpl(ProjectsRepository projects_repository,ModelMapper modelMapper) {
		this.projects_repository=projects_repository;
		this.modelMapper=modelMapper;
	}
	@Override
	public List<Object[]> getProjectsList() {
		List<Object[]> liste = projects_repository.getProjectsList();
		return liste;
	}
	@Override
	public Projects getProjectsDetail(Integer id) {
		return projects_repository.getProjectsDetail(id);
	}
	@Override
	public Projects addProjects(Projects projects) {
		return projects_repository.save(projects);
	}
	public Projects ProjectsSearch(Integer projectsid) {
		return projects_repository.getOne(projectsid);
	}
	public void deleteProjects(Projects projects) {
		projects_repository.delete(projects);
	}
	@Override
	public Projects getById(Integer id) {
        Projects p=projects_repository.getOne(id);
		return p;
	}
	@Override
	public Boolean delete(Integer id) {
		 projects_repository.deleteById(id);
	        return true;
	}
	
	@Override 
	public void update(Projects projects) {
		projects_repository.save(projects);
	}
}
