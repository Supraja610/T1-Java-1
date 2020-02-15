package com.cts.training.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Following {
	
	@Id
	private Integer userId;
	@Column
	private Integer followerId;
	
	
	public Following() {
		// TODO Auto-generated constructor stub
	}
	
	public Following(Integer userId, Integer followerId) {
		
		this.userId = userId;
		this.followerId = followerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}

	@Override
	public String toString() {
		return "Following [userId=" + userId + ", followerId=" + followerId + "]";
	}
	
	
}
