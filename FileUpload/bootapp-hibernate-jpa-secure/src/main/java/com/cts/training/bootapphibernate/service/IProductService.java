package com.cts.training.bootapphibernate.service;

import java.util.List;

import com.cts.training.bootapphibernate.entity.Product;
import com.cts.training.bootapphibernate.model.ProductModel;

public interface IProductService {

	List<Product> findAllProducts();
	Product findProductById(Integer id);
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Integer id);
}
