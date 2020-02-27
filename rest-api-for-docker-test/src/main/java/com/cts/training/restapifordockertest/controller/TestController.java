package com.cts.training.restapifordockertest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.restapifordockertest.model.ResponseModel;

@RestController
public class TestController {

	@GetMapping("/test")
	public ResponseEntity<ResponseModel> test(){
		ResponseModel model = new ResponseModel();
		model.setMessage("Testing REST endpoint-plugin update");
		model.setTimestamp(System.currentTimeMillis());
		
		ResponseEntity<ResponseModel> response = 
				new ResponseEntity<ResponseModel>(model, HttpStatus.OK);
		
		return response;
	}
}
