package com.cts.training.spring.services;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements IMessageService{
	
	@Override
	public String sendMessage(String to, String message) {
		return "SMS sent to : " + to + "[ * " + message + " * ]";
	}
}
