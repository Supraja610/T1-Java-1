package com.cts.training.hibernatemapping.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.training.hibernatemapping.entity.Passport;
import com.cts.training.hibernatemapping.entity.Student;

@Repository

public class StudentDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// dependency
	@Autowired
	private EntityManager em;
	
	@Transactional
	public Student findById(Integer id) {
		Student student = this.em.find(Student.class, id);
		logger.info("Student Data : "  + student);
		// demanding data , LAZY loading will run query now to get passport data 
		logger.info("Passport : " + student.getPassport());
		return student;
	}
	
	@Transactional
	public Student addStudent(Student student) {
		this.em.persist(student);
		return student;
	}
	
	@Transactional
	public Student addStudentAndPassport(Student student, Passport passport) {
		// student.setPassport(passport);
		// insert into student
		this.em.persist(student);
		
		// insert into passport
		// this.em.persist(passport);
		
		// updating the student record
		student.setPassport(passport);
		return student;
	}
	@Transactional
	public Student addStudentAndPassportPro(Student student, Passport passport) {
		// student.setPassport(passport);
		// insert into student
		this.em.persist(student);
		
		// insert into passport
		this.em.persist(passport);
		
		// updating the student record
		student.setPassport(passport);
		
		student.setName("NewName");
		passport.setPassportNumber("Z12345");
		
		return student;
	}
}
