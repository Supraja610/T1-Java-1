package com.cts.training.spring.services;

public class SmsService implements IMessageService{
	
	@Override
	public String sendMessage(String to, String message) {
		return "SMS sent to : " + to + "[ * " + message + " * ]";
	}
}
