package com.cts.training.spring.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstriantValidator implements ConstraintValidator<CourseCode, String>{

	private String expectedCode;
	// method that will provide code expected
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		this.expectedCode = constraintAnnotation.code();
	}
	
	// if data is good return : true else false
	// actualData : data entered by user
	@Override
	public boolean isValid(String actualData, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if(actualData.startsWith(this.expectedCode))
			return true;
		return false;
	}

}
