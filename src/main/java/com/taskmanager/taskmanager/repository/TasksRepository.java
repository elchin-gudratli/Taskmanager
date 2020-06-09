package com.taskmanager.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taskmanager.taskmanager.entity.Tasks;
import com.taskmanager.taskmanager.entity.Users;

public interface TasksRepository extends JpaRepository<Users,Integer>{

	@Query(value = "select * from tasks", nativeQuery = true)
	

	List<Tasks> getTasksList();
	
}
