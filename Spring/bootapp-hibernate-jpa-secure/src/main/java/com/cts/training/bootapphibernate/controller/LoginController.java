package com.cts.training.bootapphibernate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bootapphibernate.model.ResponseData;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// testing end-point
	
	@GetMapping("/login")
	public ResponseEntity<ResponseData> login() {
		// if called then credentials are valid
		logger.info("Logged In...");
		
		ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis());

		ResponseEntity<ResponseData> response = 
					new ResponseEntity<ResponseData>(data, HttpStatus.OK);
		
		return response;
		
	}
}
