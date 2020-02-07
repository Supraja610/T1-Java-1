package com.cts.training.spring.web.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


// which class provides validation logic
// @Constraint(validatedBy = <class that contain logic>)
@Constraint(validatedBy = CourseCodeConstriantValidator.class)
// Target for annotation
@Target({ElementType.FIELD, ElementType.METHOD})
// what is the nature of annotation : runtime/compile (Retention Policy)
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode { // @interface represents annotation
	// for every attribute a method is declared
	public String code() default "CTS";
	public String message() default "Invalid Code!!!";
	
	// boiler-plate attributes to be added
	// 1. groups : used to chain multiple constraint
	// 2. payload : additional info about validation ( severty level, error-code )
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
