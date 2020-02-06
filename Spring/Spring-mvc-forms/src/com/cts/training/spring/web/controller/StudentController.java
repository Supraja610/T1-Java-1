package com.cts.training.spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String save(@ModelAttribute Student student) {
		// display on console
		System.out.println("NAME : " + student.getUname());
		System.out.println("EMAIL : " + student.getEmail());
		
		// need to share student object with view
		// @ModelAttribute : auto adds to model box
		
		return "student-confirm";
	}
	
	
}












