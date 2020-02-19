package com.cts.training.hibernatemapping.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.training.hibernatemapping.HibernateMappingApplication;
import com.cts.training.hibernatemapping.entity.Course;
import com.cts.training.hibernatemapping.entity.Review;

@RunWith(SpringRunner.class) // Test Runner
@SpringBootTest(classes =  HibernateMappingApplication.class )
class CourseDaoTests {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	/*@Test
	void testFindCourseById() {
		Review review =  this.reviewDao.findById(1);
		assertEquals("Good", review.getReview());
	}*/
	
	/*@Test
	void testFindReviewById() {
		Review review =  this.reviewDao.findById(1);
		assertEquals("Good", review.getReview());
	}*/
	/*@Test
	void testAddCourseWithoutReview() {
		Course course = new Course();
		course.setName("C#");
		Course added = this.courseDao.addCourseWithoutReview(course);
		assertEquals("C#", added.getName());
	}*/
	
	@Test
	void testAddCourseWithReviews() {
		Course course = new Course();
		course.setName("Kotlin");
		
		List<Review> reviews = new ArrayList<Review>();
		
		Review review1 = new Review();
		review1.setReview("Futuristic");
		reviews.add(review1);
		Review review2 = new Review();
		review2.setReview("Good for mobile");
		reviews.add(review2);
		
		
		Course added = this.courseDao.addCourseWithReviews(course, reviews);
		assertEquals("Kotlin", added.getName());
	}


}
