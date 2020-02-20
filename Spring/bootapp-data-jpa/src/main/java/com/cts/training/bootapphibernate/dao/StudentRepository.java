package com.cts.training.bootapphibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.bootapphibernate.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>  {

}
