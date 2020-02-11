package com.cts.training.mavenweb.services;

import java.util.List;

import com.cts.training.mavenweb.entity.Student;

public interface IStudentService {

	List<Student> findAllStudents();
	Student findStudentById(Integer id);
	boolean addStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(Integer id);
}
