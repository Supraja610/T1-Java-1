package com.cts.training.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/dashboard")
	public String home() {
		return "student-home";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "student-profile";
	}
	
	// mapping action method with parent url
	@RequestMapping() // default method for parent url
	public String defaultMethod() {
		return "student-home";
	}
	
	// Fallback url mapping (for bad urls)
	@RequestMapping("*") // fallback method for bad url
	public String fallbackMethod() {
		return "student-error";
	}
}












