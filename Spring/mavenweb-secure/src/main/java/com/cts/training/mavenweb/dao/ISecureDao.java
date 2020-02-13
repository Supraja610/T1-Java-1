package com.cts.training.mavenweb.dao;

import java.util.List;

import com.cts.training.mavenweb.entity.Role;
import com.cts.training.mavenweb.entity.User;

public interface ISecureDao {

	public boolean register(User user, List<Role> roles);
	
	// more methods can be added
}
