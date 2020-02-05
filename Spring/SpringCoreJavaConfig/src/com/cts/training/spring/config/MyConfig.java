package com.cts.training.spring.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cts.training.spring.services.IFortuneService;
import com.cts.training.spring.services.PersonalFortune;
import com.cts.training.spring.services.ProfessionalFortune;

// read/Treat this class as config class
@Configuration
// Component scanning path
@ComponentScan("com.cts.training.spring")
// referring to property file
@PropertySource("classpath:message-repo.properties")
public class MyConfig {
	
	// method to add logic to decide which Fortune Service to expose...
	// whatever returned (exposing) will be injected
	// mehtod : bean id
	// need to tell spring this method is exposing  bean
	@Bean
	public IFortuneService fortuneService() {
		if(LocalTime.now().getHour() < 11 || LocalTime.now().getHour() > 17)
			return new PersonalFortune();
		return new ProfessionalFortune();
	}
}
