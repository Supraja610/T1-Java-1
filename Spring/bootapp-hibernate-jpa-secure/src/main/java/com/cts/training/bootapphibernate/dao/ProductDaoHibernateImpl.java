package com.cts.training.bootapphibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.training.bootapphibernate.entity.Product;


// using EntityManager and using JPA native methods
@Repository
@Transactional
public class ProductDaoHibernateImpl implements IProductDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// dependency
	// private SessionFactory sessionFactory;
	private EntityManager em;
	
	@Autowired
	public ProductDaoHibernateImpl(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	@Override
	public List<Product> findAll() {
		// Hibernate method : HQL equivalent to JPQL
		// JPA method : JPQL 
		Query query =  this.em.createQuery("from Product");
		List<Product> products = query.getResultList();
		logger.info("LIST :" + products);
		return products;
	}

	@Override
	public Product findById(Integer id) {
		
		Product product = this.em.find(Product.class, id);
		
		return product;
	}

	@Override
	public boolean add(Product product) {
		// this.em.persist(product);
		// if id in object is empty or null, it will insert, else update
		this.em.merge(product);
		return true;
	}

	@Override
	public boolean update(Product product) {
		this.em.merge(product);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		this.em.remove(this.findById(id));
		return true;
	}

}



























