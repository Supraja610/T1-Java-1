package com.cts.training.mavenweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.training.mavenweb.dao.IStudentDao;
import com.cts.training.mavenweb.entity.Student;

// @Component
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public List<Student> findAllStudents() {
		// add additional logic
		return this.studentDao.findAll();
	}

	@Override
	public Student findStudentById(Integer id) {
		// TODO Auto-generated method stub
		return this.studentDao.findById(id);
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.add(student);
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.update(student);
	}

	@Override
	public boolean deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		return this.studentDao.delete(id);
	}

}
