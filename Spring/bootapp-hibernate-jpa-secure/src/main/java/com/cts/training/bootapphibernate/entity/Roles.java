package com.cts.training.bootapphibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
// @Table(name = "authorities",uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
@Table(name = "authorities") // ,uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
public class Roles implements Serializable{
	

	@Id
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "authority")
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
