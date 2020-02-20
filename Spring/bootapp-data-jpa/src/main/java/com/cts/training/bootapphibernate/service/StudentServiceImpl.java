package com.cts.training.bootapphibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.cts.training.bootapphibernate.dao.StudentRepository;
import com.cts.training.bootapphibernate.entity.Student;

// @Component
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAllStudents() {
		// add additional logic
		return this.studentRepository.findAll();
	}
	
	@Override
	public Student findStudentById(Integer id) {
		// TODO Auto-generated method stub
		// resolves problem of null reference exception
		Optional<Student> record =  this.studentRepository.findById(id);
		// reduces the chance of NullException
		
		// can check if object is there
		Student student = new Student();
		if(record.isPresent())
			student = record.get();
		return student;
		
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentRepository.save(student);
		return true;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentRepository.save(student);
		return true;
	}

	@Override
	public boolean deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		this.studentRepository.deleteById(id);
		return true;
	}

}
