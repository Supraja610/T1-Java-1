package com.cts.training.spring.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// need to tell spring to create and manage object of this class
// by default exposed with id same as class name, with first char being small i.e emailService
// @Component([id])
@Component("msgService")
@Scope("singleton")
public class EmailService implements IMessageService{
	
	// @Value("admin@mail.com")
	// used to inject literal values
	@Value("${mail.sender}") // read values from properties file (reffered in xml)
	private String sender;
	
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
	// @Qualifier("personalFortune") // which implementation of IFortuneService to inject
	public void xyz(IFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@PostConstruct // auto register this method as init-method (LC hook method)
	public void init() {
		System.out.println("Init method");
	}
	
	@Override
	public String sendMessage(String to, String message) {
		return "Email sent to : " + to + "[ * " + message + " * ]"
				+ "\n" + "Sent By : " + this.sender
				+ "\n" + this.fortuneService.dailyFortune();
				
	}
	
	@PreDestroy // auto register this method as destroy-method (LC hook method) 
	public void destroy() {
		System.out.println("Destroy method");
	}
	
}
