package com.taskmanager.taskmanager.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.entity.Teams;
import com.taskmanager.taskmanager.repository.TeamsRepository;
import com.taskmanager.taskmanager.service.TeamsService;


@Service
public class TeamsServiceImpl implements TeamsService{

	private final TeamsRepository teams_repository;
	
	@SuppressWarnings("unused")
	private final ModelMapper modelMapper;
	
	public TeamsServiceImpl(TeamsRepository teams_repository,ModelMapper modelMapper) {
		this.teams_repository = teams_repository;
		this.modelMapper = modelMapper;
		
	}

	@Override
	public List<Teams> getTeamsList() {
		List<Teams> liste = teams_repository.getTeamsList();
		return liste;
	}
	
}
