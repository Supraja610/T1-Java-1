package com.cts.training.mavenweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.training.mavenweb.dao.ISecureDao;
import com.cts.training.mavenweb.entity.Role;
import com.cts.training.mavenweb.entity.User;
import com.cts.training.mavenweb.model.UserDetails;

@Service
public class CustomSecureService implements ISecureService {

	// dependency
	@Autowired
	private ISecureDao secureDao;
	
	@Override
	public boolean register(UserDetails userDetails) {
		// TODO Auto-generated method stub
		// divide userDetails object into User and Role Object
		/******** USER **********/
		User user = new User();
		user.setUserName(userDetails.getUserName());
		user.setPassword("{noop}" + userDetails.getPassword());
		// user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userDetails.getPassword()));;
		user.setEmail(userDetails.getEmail());
		user.setContact(userDetails.getContact());
		
		/********* Roles ************/
		// for each role selected an Role object is to be created
		List<Role> roles = new ArrayList<Role>();
		for(String roleName : userDetails.getRoles()) {
			Role role = new Role();
			role.setUserName(userDetails.getUserName());
			role.setRole("ROLE_" + roleName);
			roles.add(role);
		}
		
		// call DAO method
		this.secureDao.register(user, roles);
		
		
		
		return true;
	}

}
