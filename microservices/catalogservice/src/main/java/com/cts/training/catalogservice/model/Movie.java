package com.cts.training.catalogservice.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
	
	
	private Integer id;
	
	private String movieName;
	
	private String category;
}
