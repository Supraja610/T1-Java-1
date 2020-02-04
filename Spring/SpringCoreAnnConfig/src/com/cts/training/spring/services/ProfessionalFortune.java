package com.cts.training.spring.services;

import org.springframework.stereotype.Component;

@Component
public class ProfessionalFortune implements IFortuneService {

	@Override
	public String dailyFortune() {
		// TODO Auto-generated method stub
		return "Today your Team Leader is on leave...";
	}

}
