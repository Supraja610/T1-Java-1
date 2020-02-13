package com.cts.training.mavenweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.training.mavenweb.model.UserDetails;
import com.cts.training.mavenweb.service.ISecureService;

@Controller
public class LoginController {

	// dependency
	@Autowired
	private ISecureService secureService;
	
	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		UserDetails userDetails = new UserDetails();
		
		model.addAttribute("userDetails", userDetails);
		return "register";
	}
	
	@RequestMapping("/register-save")
	public String registerSave(@ModelAttribute UserDetails userDetails) {
		// call service
		
		this.secureService.register(userDetails);
		return "redirect:/custom-login";
	}
	
}
