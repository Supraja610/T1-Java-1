package com.cts.training.spring.services;

public class EmailService implements IMessageService{
	
	// add dependency
	
	// which fortune service : decided in config
	private IFortuneService fortuneService;
	
	// sender literal value is to be injected by spring-context
	private String sender;
	
	private static int instances;
	static {
		instances = 0;
	}
	
	public EmailService() {
		System.out.println("\n**********Email Object created*********");
		EmailService.instances++;
	}
	
	
	
	
	
	
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
	
	/***************  Setter Based DI *************/
	// param sender will be injected by spring-context
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
	public void postConstruct() {
		System.out.println("\n*******Post Construct called********\n");
	}
	
	@Override
	public String sendMessage(String to, String message) {
		return "Email(" + EmailService.instances + ") sent to : " + to + "[ * " + message + " * ]"
				+ "\nSent By : " + this.sender
				+ "\n" + this.fortuneService.dailyFortune();
	}
	
	public void preDestroy() {
		System.out.println("\n*******Pre Destroy called********\n");
	}
}
