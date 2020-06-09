package com.taskmanager.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taskmanager.taskmanager.entity.Teams;

public interface TeamsRepository extends JpaRepository<Teams,Integer>{
	
	@Query(value = "select * from teams", nativeQuery = true)
	List<Teams> getTeamsList();

}
