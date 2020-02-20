package com.cts.training.bootapphibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cts.training.bootapphibernate.entity.Student;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Student> someVeryComplexRequirement() {
		// TODO Auto-generated method stub
		return null;
	}

}
