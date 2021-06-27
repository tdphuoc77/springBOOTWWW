package com.onthi.bai17client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate	 restTemplate() {
		RestTemplate restTemplate= new RestTemplate();
		
		DefaultUriBuilderFactory builderFactory= new DefaultUriBuilderFactory("http://localhost:7070/");
		restTemplate.setUriTemplateHandler(builderFactory);
		return restTemplate;
	}
}
