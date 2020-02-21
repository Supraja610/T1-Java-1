package com.cts.training.catalogservice.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.training.catalogservice.model.Movie;


// registering interface as feign client proxy
// 1. url (name of the microservice)
// 2. connection details of microservice (IP/PORT)
// @FeignClient(name = "movie-service", path = "http://localhost:9090") // context-path
@FeignClient(name = "movie-service") // path is managed by server
// configure the Ribbon to load balance
@RibbonClient(name = "movie-service") // will activate load balancing on movie-service
public interface MovieServiceProxy {
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Movie> movieDetail(@PathVariable Integer movieId);
}
