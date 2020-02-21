package com.cts.training.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.training.catalogservice.model.Catalog;
import com.cts.training.catalogservice.model.CatalogData;
import com.cts.training.catalogservice.model.Movie;
import com.cts.training.catalogservice.model.RatingData;
import com.cts.training.catalogservice.model.RatingModel;

@RestController
public class CatalogController {

	// dependency
	@Autowired
	private RestTemplate restTemplate;
	
	private final String RATING_URL = "http://localhost:6060/rating-service/ratings";
	private final String MOVIE_URL = "http://localhost:9090/movie-service/movies"; 
	// Controller method recieves userId and return list of movies viewed by that user + movie details + rating
	// ENDPOINT : /catalog/{userId}
	@GetMapping("/catalog/{userId}")
	public ResponseEntity<CatalogData> getCatalogs(@PathVariable Integer userId){
		
		// 1. sent a request to rating service to fetch the list of movies
		RatingData ratingData = this.restTemplate.getForObject(RATING_URL + "/" + userId, RatingData.class);
		
		// 2. sent request to movie service to fetch movie details
		// need to loop through movielist(ratingData)
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		
		for(RatingModel ratingModel : ratingData.getRatingModels()) {
			Integer movieId =  ratingModel.getMovieId();
			Movie movie = this.restTemplate.getForObject(MOVIE_URL + "/" + movieId, Movie.class);
			
			// club both info in Catalog
			Catalog catalog = new Catalog(movieId, 
										  movie.getMovieName(), 
										  movie.getCategory(), 
										  ratingModel.getRating());
			
			// add to collection of catalogs
			catalogs.add(catalog);		
		}
		
		CatalogData catalogData = new CatalogData();
		catalogData.setUserId(userId);
		catalogData.setCatalogs(catalogs);
		
		ResponseEntity<CatalogData> response = 
				new ResponseEntity<CatalogData>(catalogData, HttpStatus.OK);
		
		return response;
	}
}









