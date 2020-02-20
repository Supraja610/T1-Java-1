package com.cts.training.bootapphibernate.service;

import java.util.List;

import com.cts.training.bootapphibernate.entity.Student;

public interface IStudentService {

	List<Student> findAllStudents();
	Student findStudentById(Integer id);
	boolean addStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(Integer id);
}
