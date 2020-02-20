package com.cts.training.bootapphibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bootapphibernate.entity.Product;
import com.cts.training.bootapphibernate.exception.ProductErrorResponse;
import com.cts.training.bootapphibernate.exception.ProductNotFoundException;
import com.cts.training.bootapphibernate.service.IProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProductRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// dependency
	@Autowired
	private IProductService productService;
	
	// @RequestMapping(value =  "/products", method = {RequestMethod.GET, RequestMethod.PUT} )
	@GetMapping("/products") // GET HTTP VERB
	public ResponseEntity<List<Product>> exposeAll() {
		
		List<Product> products = this.productService.findAllProducts();
		// if(products.size() == 0)
		if(products == null)
			throw new ProductNotFoundException("Not able to fetch records!!!");
		ResponseEntity<List<Product>> response = 
								new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
		
		return response;
	}
	
	// {<data variable>}
	@GetMapping("/products/{productId}") // GET HTTP VERB
	public ResponseEntity<Product> getById(@PathVariable Integer productId) {
		
		Product product = this.productService.findProductById(productId);
		if(product == null)
			throw new ProductNotFoundException("Product with id-" + productId + " not Found");
		
		ResponseEntity<Product> response = 
				new ResponseEntity<Product>(product, HttpStatus.OK);

		return response;
	}
	
	// @RequestMapping(value =  "/products", method = RequestMethod.POST)
	@PostMapping("/products") // POST HTTP VERB
	public ResponseEntity<Product> save(@RequestBody Product product) {
		if(!this.productService.addProduct(product))
			throw new RuntimeException("Could not add new record!!!");
		ResponseEntity<Product> response = 
				new ResponseEntity<Product>(product, HttpStatus.OK);

		return response;
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> saveUpdate(@RequestBody Product product) {
		if(!this.productService.updateProduct(product))
			throw new RuntimeException("Could not update record!!!");
		ResponseEntity<Product> response = 
				new ResponseEntity<Product>(product, HttpStatus.OK);

		return response;
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product> delete(@PathVariable Integer productId) {
		
		Product product = this.productService.findProductById(productId);
		if(product == null)
			throw new ProductNotFoundException("Product with id-" + productId + " not Found");
		
		// send productId to DAO via SERVICE
		this.productService.deleteProduct(productId);
		
		ResponseEntity<Product> response = 
				new ResponseEntity<Product>(product, HttpStatus.OK);

		return response;
	}
	
	
	// for exception handling
	@ExceptionHandler  // ~catch
	public ResponseEntity<ProductErrorResponse> productNotFoundHandler(ProductNotFoundException ex) {
		// create error object
		ProductErrorResponse error = new ProductErrorResponse(ex.getMessage(), 
															  HttpStatus.NOT_FOUND.value(), 
															  System.currentTimeMillis());
		ResponseEntity<ProductErrorResponse> response =
										new ResponseEntity<ProductErrorResponse>(error, HttpStatus.NOT_FOUND);
		
		return response;
	}
	
	@ExceptionHandler  // ~catch
	public ResponseEntity<ProductErrorResponse> productOperationErrorHAndler(Exception ex) {
		// create error object
		ProductErrorResponse error = new ProductErrorResponse(ex.getMessage(), 
															  HttpStatus.BAD_REQUEST.value(), 
															  System.currentTimeMillis());
		ResponseEntity<ProductErrorResponse> response =
										new ResponseEntity<ProductErrorResponse>(error, HttpStatus.NOT_FOUND);
		logger.error("Exception :" + error);
		
		return response;
	}
	
	
	
	/************ REST endpoints ************/
	// /api/product [GET]
	// /api/product/id [GET]
	// /api/product [POST]
	// /api/product [PUT]
	// /api/product/id [DELETE]
	
	
	
	
}
