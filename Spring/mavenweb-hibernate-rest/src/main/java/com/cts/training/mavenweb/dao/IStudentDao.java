package com.cts.training.mavenweb.dao;

import java.util.List;

import com.cts.training.mavenweb.entity.Student;

public interface IStudentDao {

	List<Student> findAll();
	Student findById(Integer id);
	boolean add(Student student);
	boolean update(Student student);
	boolean delete(Integer id);
}
