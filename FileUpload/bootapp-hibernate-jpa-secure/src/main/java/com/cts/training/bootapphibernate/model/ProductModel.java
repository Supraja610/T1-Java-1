package com.cts.training.bootapphibernate.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ProductModel implements Serializable{

	private Integer userId;
	private String name;
	private MultipartFile file;
	private String category;
	private Integer cost;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ProductModel(String name, MultipartFile file, String category, Integer cost, String url) {
		
		this.name = name;
		this.file = file;
		this.category = category;
		this.cost = cost;
		this.url = url;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
