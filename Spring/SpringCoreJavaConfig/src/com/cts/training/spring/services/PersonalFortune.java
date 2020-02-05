package com.cts.training.spring.services;

import org.springframework.stereotype.Component;

// @Component
public class PersonalFortune implements IFortuneService {

	@Override
	public String dailyFortune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day!!!";
	}

}
