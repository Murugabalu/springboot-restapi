package com.learning.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.restservices.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String userName);
	
}
