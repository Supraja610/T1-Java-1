package com.cts.training.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Component properties + registered as controller under Handler Mapper
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// must always return view name
		return "home-page";
		
	}
	
}
