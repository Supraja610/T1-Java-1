package com.cts.training.ratingservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.ratingservice.entity.Rating;
import com.cts.training.ratingservice.model.RatingData;
import com.cts.training.ratingservice.model.RatingModel;
import com.cts.training.ratingservice.repository.RatingRepository;

@RestController
public class RatingController {

	// dependency
	@Autowired
	private RatingRepository ratingRepository;
	
	// REST method will reciever userId and return a List of movies + ratings viewed by that user
	// ENDPOINT : /ratings/{userId}
	// @GetMapping("/ratings/{ratingId}")
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<RatingData> getRatings(@PathVariable Integer userId){
		List<Rating> ratings = this.ratingRepository.findRatingsByUserId(userId);
		
		// convert List<Rating>  to   List<RatingModel>
		/*List<RatingModel> ratingModels = new ArrayList<RatingModel>();
		for(Rating rating : ratings) {
			RatingModel ratingModel = new RatingModel(rating.getMovieId(), rating.getRating());
			ratingModels.add(ratingModel);
		}*/
		
		List<RatingModel> ratingModels = ratings.stream()
				.map(rating -> {
					RatingModel ratingModel = new RatingModel(rating.getMovieId(), rating.getRating());
					return ratingModel;
				})
				.collect(Collectors.toList());
		
		// encapsulate inside RatingData
		RatingData ratingData = new RatingData();
		ratingData.setUserId(userId);
		ratingData.setRatingModels(ratingModels);
				
		
		// best pratices : never return a collection directly
		// 1. For large data streaming and buffering issue
		// 2. No provision to add any new information
		ResponseEntity<RatingData> response = 
								new ResponseEntity<RatingData>(ratingData, HttpStatus.OK);
		return response;
		 
	}
}












