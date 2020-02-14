package com.cts.training.mavenweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.mavenweb.entity.Student;
import com.cts.training.mavenweb.exception.StudentErrorResponse;
import com.cts.training.mavenweb.exception.StudentNotFoundException;
import com.cts.training.mavenweb.services.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// dependency
	@Autowired
	private IStudentService studentService;
	
	// @RequestMapping(value =  "/students", method = {RequestMethod.GET, RequestMethod.PUT} )
	@GetMapping("/students") // GET HTTP VERB
	public List<Student> exposeAll() {
		
		List<Student> students = this.studentService.findAllStudents();
		
		return students;
	}
	
	// {<data variable>}
	@GetMapping("/students/{studentId}") // GET HTTP VERB
	public Student getById(@PathVariable Integer studentId) {
		
		Student student = this.studentService.findStudentById(studentId);
		if(student == null)
			throw new StudentNotFoundException("Student with id-" + studentId + " not Found");
		return student;
	}
	
	// @RequestMapping(value =  "/students", method = RequestMethod.POST)
	@PostMapping("/students") // POST HTTP VERB
	public Student save(@RequestBody Student student) {
		this.studentService.addStudent(student);
		return student;
	}
	
	@PutMapping("/students")
	public Student saveUpdate(@RequestBody Student student) {
		this.studentService.updateStudent(student);
		return student;
	}
	
	@DeleteMapping("/students/{studentId}")
	public Student delete(@PathVariable Integer studentId) {
		
		Student student = this.studentService.findStudentById(studentId);
		
		// send studentId to DAO via SERVICE
		this.studentService.deleteStudent(studentId);
		
		return student;
	}
	
	// for exception handling
	@ExceptionHandler  // ~catch
	public StudentErrorResponse studentNotFoundHandler(StudentNotFoundException ex) {
		// create error object
		StudentErrorResponse error = new StudentErrorResponse(ex.getMessage(), 
															  HttpStatus.NOT_FOUND.value(), 
															  System.currentTimeMillis());
		return error;
	}
	
	
	
	/************ REST endpoints ************/
	// /api/student [GET]
	// /api/student/id [GET]
	// /api/student [POST]
	// /api/student [PUT]
	// /api/student/id [DELETE]
	
	
	
	
}
