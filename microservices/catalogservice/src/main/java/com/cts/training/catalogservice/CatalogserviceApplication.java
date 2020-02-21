package com.cts.training.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// enable to use the feign client : allow feign to connect to Microservices
// @EnableFeignClients(<package where proxy interaface are>)
@EnableFeignClients("com.cts.training.catalogservice.feignproxy")
// enable/register as eureka client
@EnableEurekaClient
public class CatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogserviceApplication.class, args);
	}
	
	// config method to expose RestTemplate
	@Bean
	// @LoadBalanced
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		// add additional 
		return restTemplate;
	}

}
