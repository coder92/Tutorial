package com.tutorial.spring.springboot.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/resttemplate")
public class RestAPIHandler {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("")
	public String welComeMsg() {
		return "welcome to REST API HANDLER";
	}
	
	@RequestMapping(value = "/products")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
	}
}
