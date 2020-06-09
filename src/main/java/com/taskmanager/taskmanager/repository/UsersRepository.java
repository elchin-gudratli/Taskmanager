package com.taskmanager.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.taskmanager.taskmanager.entity.Users;



public interface UsersRepository extends JpaRepository<Users,Integer> {
	

	
			@Query(value = "select u.name,u.surname,u.role,d.name as departmanadi,u.id from users as u join departments as d on u.department_id = d.id join status as s on u.status_id = s.id", nativeQuery = true)
	List<Object[]> getUsersList();
	
	@Query(value = "select * from users as u where u.id = ?1 ", nativeQuery = true)
	Users getUserDetail(Integer id);
	


}
