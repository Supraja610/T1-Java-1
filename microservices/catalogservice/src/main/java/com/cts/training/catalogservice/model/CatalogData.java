package com.cts.training.catalogservice.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogData {
	private Integer userId;
	private List<Catalog> catalogs;
}
