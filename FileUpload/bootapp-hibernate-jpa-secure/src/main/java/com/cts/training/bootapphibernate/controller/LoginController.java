package com.cts.training.bootapphibernate.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bootapphibernate.dao.UserRepository;
import com.cts.training.bootapphibernate.entity.User;
import com.cts.training.bootapphibernate.model.ResponseData;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// testing end-point
	
	@GetMapping("/login")
	public ResponseEntity<ResponseData> login(Authentication authentication) {
		// if called then credentials are valid
		logger.info("Logged In...");
		logger.info(authentication.getName());
        
        User user = this.userRepository.findByUsername(authentication.getName()).get(0);
        logger.info("User : " + user);
        // add any additional information like firstname, lastname, profilepic etc
		ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis(), user.getId());

		ResponseEntity<ResponseData> response = 
					new ResponseEntity<ResponseData>(data, HttpStatus.OK);
		
		return response;
		
	}
}
