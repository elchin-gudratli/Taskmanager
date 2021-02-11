package com.taskmanager.taskmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query(value = "select u.name,u.surname,u.email ,u.id from users as u", nativeQuery = true)
	List<Object[]> getUsersList();
	
	@Query(value = "select * from users as u where u.id = ?1 ", nativeQuery = true)
	Users getUserDetail(Long id);

	Optional<Users> findByUsername(String username);
	
	Users getById(Integer id);

}
