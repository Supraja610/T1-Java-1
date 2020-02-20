package com.cts.training.bootapphibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.training.bootapphibernate.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustom  {

	// correct Naming Convention will provide implementation auto
	// 1. all constraints must be in same entity
	// 2. comparision will be for equality
	List<Student> findStudentsByEmail(String email);
	Student findByEmail(String email);
	
	// get all students having age > (provided age) and gpa > (provided gpa)
	@Query("select s from Student s where s.age > :providedAge and s.gpa > :providedGpa")
	List<Student> getStudentsOfSpecificCriteria(@Param("providedAge") Integer age, @Param("providedGpa") Double gpa);
}

/**
 * Total Assembly
 * 	1. All CRUD functionality
 *  2. Naming Convention methods implementation
 *  3. @Query method implementation
 *  4. Cutom interface method implementation
 */

