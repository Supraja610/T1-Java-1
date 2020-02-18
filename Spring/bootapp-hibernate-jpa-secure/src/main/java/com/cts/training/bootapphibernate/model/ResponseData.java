package com.cts.training.bootapphibernate.model;

public class ResponseData {
	private String message;
	private Long timeStamp;
	
	
	public ResponseData() {}
	
	public ResponseData(String message, Long timeStamp) {
		
		this.message = message;
		this.timeStamp = timeStamp;
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
	
	
}
