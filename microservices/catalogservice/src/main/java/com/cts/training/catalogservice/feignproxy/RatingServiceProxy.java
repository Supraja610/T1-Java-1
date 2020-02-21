package com.cts.training.catalogservice.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.training.catalogservice.model.RatingData;


// @FeignClient(name = "rating-service", path = "http://localhost:6060")
@FeignClient(name = "rating-service")
@RibbonClient(name = "rating-service") 
public interface RatingServiceProxy {
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<RatingData> getRatings(@PathVariable Integer userId);
}
