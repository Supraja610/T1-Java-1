package com.cts.training.ratingservice.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingData {

	// any additional info 
	private Integer userId;
	private List<RatingModel> ratingModels;
	
}
