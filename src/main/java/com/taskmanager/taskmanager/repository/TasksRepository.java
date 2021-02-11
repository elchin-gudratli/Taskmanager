package com.taskmanager.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taskmanager.taskmanager.entity.Tasks;

public interface TasksRepository extends JpaRepository<Tasks,Integer>{
	
	@Query(value = "select * from tasks",nativeQuery=true)
	List<Object[]> getTasksList();
	

	@Query(value = "select * from tasks as p where p.id = ?1 ", nativeQuery = true)
	Tasks getTasksDetail(Integer id);
}
