package com.cts.training.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
public class Authorities {
	
	@Column
	private String userName;
	@Column
	private String authority;
	
	
	public Authorities() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Authorities(String userName, String authority) {
	
		this.userName = userName;
		this.authority = authority;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}


	@Override
	public String toString() {
		return "Authorities [userName=" + userName + ", authority=" + authority + "]";
	}

	
	
	
}
