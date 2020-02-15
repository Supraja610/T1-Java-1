package com.cts.training.product.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table
public class Media {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer userId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String mimeType;
	@Column
	private Integer size;
	@Column
	private String posterFileUrl;
	@Column
	private String fileUrl;
	@Column
	private Boolean hide;
	@Column
	@CreationTimestamp
	private LocalDateTime createdOn;
	@Column
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	@Column
	private String tags;
	
	
	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Media(Integer id, Integer userId, String title, String description, String mimeType, Integer size,
			String posterFileUrl, String fileUrl, Boolean hide, LocalDateTime createdOn, LocalDateTime updatedOn,
			String tags) {
		
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.mimeType = mimeType;
		this.size = size;
		this.posterFileUrl = posterFileUrl;
		this.fileUrl = fileUrl;
		this.hide = hide;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.tags = tags;
	}
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getPosterFileUrl() {
		return posterFileUrl;
	}
	public void setPosterFileUrl(String posterFileUrl) {
		this.posterFileUrl = posterFileUrl;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Boolean getHide() {
		return hide;
	}
	public void setHide(Boolean hide) {
		this.hide = hide;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
	
	@Override
	public String toString() {
		return "Media [id=" + id + ", userId=" + userId + ", title=" + title + ", description=" + description
				+ ", mimeType=" + mimeType + ", size=" + size + ", posterFileUrl=" + posterFileUrl + ", fileUrl="
				+ fileUrl + ", hide=" + hide + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", tags="
				+ tags + "]";
	}
	
}
