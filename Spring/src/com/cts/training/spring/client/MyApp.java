package com.cts.training.spring.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.training.spring.services.EmailService;
import com.cts.training.spring.services.IMessageService;
import com.cts.training.spring.services.SmsService;

// Client Code...

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// fetch an instance of bean factory based on config file
		// need to specify which xml to read for config
		ClassPathXmlApplicationContext context = 
							new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// fetch the object
		IMessageService service = context.getBean("msgService", IMessageService.class);
		String ack = service.sendMessage("someone", "Hello");
		System.out.println(ack);
	}

}



























