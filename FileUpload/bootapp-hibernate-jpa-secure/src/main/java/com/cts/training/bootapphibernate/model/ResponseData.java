package com.cts.training.bootapphibernate.model;

public class ResponseData {
	private String message;
	private Long timeStamp;
	private Integer userId;
	
	
	public ResponseData() {}
	
	public ResponseData(String message, Long timeStamp,Integer userId) {
		
		this.message = message;
		this.timeStamp = timeStamp;
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
