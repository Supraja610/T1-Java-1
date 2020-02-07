package com.cts.training.spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String profile() {
		return "student-profile";
	}
	
	// query String
	// http://localhost:9090/Spring-mvc/student/save?uname=First&email=first@mail.com
	// Traditional Servlet way
	/*@RequestMapping("/save") 
	public String saveData(HttpServletRequest request) {
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		System.out.println("\nName : " + uname);
		System.out.println("Email : " + email);
		return "student-confirm";
	}*/
	
	// Spring way
	/*@RequestMapping("/save") 
	// public String saveData(@RequestParam String uname, @RequestParam String email) {
	public String saveData(@RequestParam("uname") String userName, @RequestParam(value = "email", required = false, defaultValue = "dummy@mail.com") String userEmail) {
		// System.out.println("\nName : " + uname);
		// System.out.println("Email : " + email);
		
		System.out.println("\nName : " + userName);
		System.out.println("Email : " + userEmail.toUpperCase());
		return "student-confirm";
	}*/
	
	// Spring way (using model class, Model Box)
	/*@RequestMapping("/save") 
	// Model box is passed as an argument to all Action method
	public String saveData(Student student, Model model) {
		System.out.println("\nName : " + student.getUname());
		System.out.println("Email : " + student.getEmail());
		
		// process data (convert data into upper case)
		student.setUname(student.getUname().toUpperCase());
		student.setEmail(student.getEmail().toUpperCase());
		
		
		// share data with view
		// put data in Model Box (inbuilt), will be shared with view
		// model.addAttribute(<key>, <value>);
		model.addAttribute("stud", student);
		
		
		return "student-confirm";
	}*/
	
	// Spring way (using model class, Model Box) alt
	// ModelAndView
	@RequestMapping("/save") 
	// Model box is passed as an argument to all Action method
	public ModelAndView saveData(Student student) {
		System.out.println("\nName : " + student.getUname());
		System.out.println("Email : " + student.getEmail());
		
		// process data (convert data into upper case)
		student.setUname(student.getUname().toUpperCase());
		student.setEmail(student.getEmail().toUpperCase());
		
		ModelAndView mv = new ModelAndView("student-confirm");
		// share data with view
		// put data in Model Box (inbuilt), will be shared with view
		// model.addAttribute(<key>, <value>);
		mv.addObject("stud", student);
		
		
		return mv;
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












