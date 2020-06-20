package com.taskmanager.taskmanager.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.entity.Projects;
import com.taskmanager.taskmanager.entity.Users;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects,Integer> {

	@Query(value = "select projects.*, priority.name as priority_name from Projects left join priority on projects.priority_id=priority.id", nativeQuery = true)
	List<Object[]> getProjectsList();

	@Query(value = "select * from projects as p where p.id = ?1 ", nativeQuery = true)
	Projects getProjectsDetail(Integer id);
	
}
