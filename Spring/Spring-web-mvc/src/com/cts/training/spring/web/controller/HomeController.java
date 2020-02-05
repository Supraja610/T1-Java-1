package com.cts.training.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Component properties + registered as controller under Handler Mapper
@Controller
public class HomeController {

	// Action Methods : containing the logic to process the request
	/*
	 * 1. Access modifier : public 
	 * 2. Return type : String
	 * 3. Name : anything
	 * 4. Parameter : depends on req
	 * 5. Url MApping
	 */
	// if user request /index (url), current method shall handle that
	// current method will be called ~ service()
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// must always return view name
		return "home-page";
		
	}
}
