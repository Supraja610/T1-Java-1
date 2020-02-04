package com.cts.training.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// need to tell spring to create and manage object of this class
// by default exposed with id same as class name, with first char being small i.e emailService
// @Component([id])
@Component("msgService")
public class EmailService implements IMessageService{
	
	// dependency over Fortune Service
	/*************** Field/Property Based DI ***********/
	// @Autowired	
	// @Qualifier("personalFortune")
	private IFortuneService fortuneService;
	
	/*************** Constructer Based DI ***********/
	// will auto going to search for an implementation of type IFortuneService
	// if found injected auto
	/* @Autowired
	public EmailService(@Qualifier("personalFortune")IFortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}*/
	
	/*************** Setter Based DI ***********/
	@Autowired
	@Qualifier("personalFortune") // which implementation of IFortuneService to inject
	public void xyz(IFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String sendMessage(String to, String message) {
		return "Email sent to : " + to + "[ * " + message + " * ]"
				+ "\n" + this.fortuneService.dailyFortune();
				
	}
	
}
