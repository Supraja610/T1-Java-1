package com.cts.training.hibernatemapping.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.training.hibernatemapping.entity.Course;
import com.cts.training.hibernatemapping.entity.Review;
import com.cts.training.hibernatemapping.entity.Review;

@Repository
@Transactional
public class ReviewDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager em;
	
	public Review findById(Integer id) {
		Review review = this.em.find(Review.class, id);
		logger.info("Review : '" + review);
		logger.info("Course : " + review.getCourse());
		return review;
	}
	
	public Review addReviewAndCourse(Review review, Course course) {
		return null;
	}
	
	public Review addReviewtoExistingCourse(Review review, Course course) {
		return null;
	}
	
	
	
	
}
