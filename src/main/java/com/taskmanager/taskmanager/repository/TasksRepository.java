package com.taskmanager.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.entity.Tasks;
import com.taskmanager.taskmanager.entity.Users;

@Repository
public interface TasksRepository extends JpaRepository<Users,Integer>{

	@Query(value = "select t.title,t.description,t.start_date,t.deadline,u.name,u.surname from tasks t left join task_users tu on t.id=tu.task_id left join users u on tu.user_id=u.id",nativeQuery=true)
	List<Object[]> getTasksList();
	
}
