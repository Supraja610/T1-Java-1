package com.cts.training.catalogservice.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.training.catalogservice.model.RatingData;


@FeignClient(name = "rating-service", path = "http://localhost:6060")
public interface RatingServiceProxy {
	@GetMapping("/ratings/{userId}")
	public ResponseEntity<RatingData> getRatings(@PathVariable Integer userId);
}
