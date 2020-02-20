package com.cts.training.bootapphibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.cts.training.bootapphibernate.entity.Student;
import com.cts.training.bootapphibernate.service.IStudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class StudentRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// dependency
	@Autowired
	private IStudentService studentService;
	
	// @RequestMapping(value =  "/students", method = {RequestMethod.GET, RequestMethod.PUT} )
	@GetMapping("/students") // GET HTTP VERB
	public ResponseEntity<List<Student>> exposeAll() {
		
		List<Student> students = this.studentService.findAllStudents();
		ResponseEntity<List<Student>> response = 
								new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
		
		return response;
	}
	
	// {<data variable>}
	@GetMapping("/students/{studentId}") // GET HTTP VERB
	public ResponseEntity<Student> getById(@PathVariable Integer studentId) {
		
		Student student = this.studentService.findStudentById(studentId);
		ResponseEntity<Student> response = 
				new ResponseEntity<Student>(student, HttpStatus.OK);

		return response;
	}
	
	// @RequestMapping(value =  "/students", method = RequestMethod.POST)
	@PostMapping("/students") // POST HTTP VERB
	public ResponseEntity<Student> save(@RequestBody Student student) {
		this.studentService.addStudent(student);
		ResponseEntity<Student> response = 
				new ResponseEntity<Student>(student, HttpStatus.OK);

		return response;
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> saveUpdate(@RequestBody Student student) {
		this.studentService.updateStudent(student);
			
		ResponseEntity<Student> response = 
				new ResponseEntity<Student>(student, HttpStatus.OK);

		return response;
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Student> delete(@PathVariable Integer studentId) {
		
		Student student = this.studentService.findStudentById(studentId);
		this.studentService.deleteStudent(studentId);
		
		ResponseEntity<Student> response = 
				new ResponseEntity<Student>(student, HttpStatus.OK);

		return response;
	}
	
}
