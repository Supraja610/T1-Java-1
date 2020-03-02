package com.cts.training.bootapphibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.bootapphibernate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	List<User> findByUsername(String username);
}
