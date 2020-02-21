package com.cts.training.movieservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.movieservice.entity.Movie;
import com.cts.training.movieservice.repository.MovieRepository;

@RestController
public class MovieController {

	// dependency
	@Autowired
	private MovieRepository movieRepository;
	
	// REST method that will recieve a movie Id and return details of that movie
	// ENDPOINT : /movies/{movieId}
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Movie> movieDetail(@PathVariable Integer movieId){
		Optional<Movie> record =  this.movieRepository.findById(movieId);
		Movie movie = new Movie();
		if(record.isPresent())
			movie = record.get();
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(movie, HttpStatus.OK);
		return response;
	}
}












