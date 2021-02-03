package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Categories;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api")
public class TestController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper om;

	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = "application/json")
	public void getCategories() throws JsonGenerationException, JsonMappingException, IOException {

		String uri = "https://www.themealdb.com/api/json/v1/1/categories.php";

		ResponseEntity<Categories> response = restTemplate.getForEntity(uri, Categories.class);

		om.writeValue(System.out, response.getBody());
		
	}

}
