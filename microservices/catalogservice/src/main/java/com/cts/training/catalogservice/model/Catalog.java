package com.cts.training.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {

	private Integer movieId;
	private String movieName;
	private String category;
	private Integer rating;
}
