package com.cts.training.hibernatemapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.training.hibernatemapping.entity.Course;
import com.cts.training.hibernatemapping.entity.Review;

@Repository
@Transactional
public class CourseDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager em;
	
	public Course findById(Integer id) {
		Course course = this.em.find(Course.class, id);
		logger.info("Course : '" + course);
		logger.info("Reviews : " + course.getReviews());
		return course;
	}
	
	public Course addCourseWithoutReview(Course course) {
		this.em.persist(course);
		return course;
	}
	public Course addCourseWithReviews(Course course,List<Review> reviews) {
		this.em.persist(course);
		
		reviews.forEach(review ->{
			review.setCourse(course);
			this.em.persist(review);
			// course.addReview(review);
		});
		
		// this.em.persist(course);
		
		return course;
	}
}









