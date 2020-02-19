package com.cts.training.hibernatemapping.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.training.hibernatemapping.HibernateMappingApplication;
import com.cts.training.hibernatemapping.entity.Course;
import com.cts.training.hibernatemapping.entity.Passport;
import com.cts.training.hibernatemapping.entity.Student;

@RunWith(SpringRunner.class) // Test Runner
@SpringBootTest(classes =  HibernateMappingApplication.class ) // where to get all context
public class StudentDaoTests {

	// dependency
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	
	/*@Test
	public void testFindById() {
		Student student = studentDao.findById(1);
		assertEquals("First", student.getName());
	}*/

	/*@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setName("Fifth");
		student.setEmail("fifth@mail.com");
		Student added = this.studentDao.addStudent(student);
		assertEquals("Fifth", student.getName());
	}*/
	
	/*@Test
	public void testAddStudentAndPassport() {
		Student student = new Student();
		student.setName("Seventh");
		student.setEmail("seventh@mail.com");
		
		Passport passport = new Passport();
		passport.setPassportNumber("X12345");
	
		Student added = this.studentDao.addStudentAndPassport(student, passport);
		assertEquals("Seventh", student.getName());
	}
	
	@Test
	public void testAddStudentAndPassportPro() {
		Student student = new Student();
		student.setName("Ninth");
		student.setEmail("ninth@mail.com");
		
		Passport passport = new Passport();
		passport.setPassportNumber("A12345");
	
		Student added = this.studentDao.addStudentAndPassportPro(student, passport);
		assertEquals("Ninth", student.getName());
	}*/
	
	/*@Test
	public void testAddStudentWithCourses() {
		Student student = new Student();
		student.setName("NewStudent");
		
		List<Course> courses = new ArrayList<Course>();
		
		Course course = new Course();
		course.setName("C1");
		courses.add(course);
		
		course = new Course();
		course.setName("C2");
		courses.add(course);
		
		Student added = this.studentDao.addStudentWithCourses(student, courses);
		
		assertEquals("NewStudent", added.getName());
		
	}*/
	
	/*@Test
	public void testAddStudentWithCourses() {
		Student student = this.studentDao.findById(2);
		
		List<Course> courses = new ArrayList<Course>();
		
		Course course = this.courseDao.findById(1);
		courses.add(course);
		
		course = this.courseDao.findById(2);
		courses.add(course);
		
		Student added = this.studentDao.addStudentWithCourses(student, courses);
		
		assertEquals("Second", added.getName());
		
	}*/

	@Test
	public void testStudentAndCourses() {
		Student student = this.studentDao.findById(2);
		assertEquals("Second", student.getName());
	}
}











