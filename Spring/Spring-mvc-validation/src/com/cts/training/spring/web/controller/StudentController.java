package com.cts.training.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.training.spring.web.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/dashboard")
	public String home() {
		return "student-home";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		// blank object of Student (bag)
		Student student = new Student();
		student.setUname("Dummy");
		// add to model to share with view page ( to map with form )
		model.addAttribute("student", student);
		return "student-profile";
	}
	
	@RequestMapping("/save")
	// Form data validated auto by @Valid annotation
	// and result is provided in an object of BindingResult
	public String save(@Valid @ModelAttribute Student student, BindingResult result) {
		// display on console
		
		// check the result
		if(result.hasErrors()) {
			return "student-profile";
		}
		
		System.out.println("NAME : " + student.getUname());
		System.out.println("EMAIL : " + student.getEmail());
		
		// need to share student object with view
		// @ModelAttribute : auto adds to model box
		
		return "student-confirm";
	}
	
	// interceptor to filter incoming data (initBinder)
	@InitBinder  // registered as interceptor
	public void initBinder(WebDataBinder binder) {
		// trim leading and training spaces
		// true : convert empty string into null
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		// tell binder wherever there is string apply trimmer
		binder.registerCustomEditor(String.class, trimmer);
	}
	
	
}












