package com.cts.training.spring.services;

public class EmailService implements IMessageService{
	
	// add dependency
	// which fortune service : decided in config
	private IFortuneService fortuneService;
	
	/************ Constructor Based DI **************/
	/*
	// param fortuneService will be injected by spring-context
	public EmailService(IFortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}*/
	
	/***************  Setter Based DI *************/
	// param fortuneService will be injected by spring-context
	public void setFortuneService(IFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String sendMessage(String to, String message) {
		return "Email sent to : " + to + "[ * " + message + " * ]"
				+ "\n" + this.fortuneService.dailyFortune();
	}
}
