package com.cts.training.mavenweb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.training.mavenweb.entity.Role;
import com.cts.training.mavenweb.entity.User;

@Repository
@Transactional
public class CustomSecureDao implements ISecureDao {

	// dependency
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean register(User user, List<Role> roles) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		// save user
		session.save(user);
		
		// save roles
		roles.forEach(role -> session.save(role));
		
		return true;
	}

}








