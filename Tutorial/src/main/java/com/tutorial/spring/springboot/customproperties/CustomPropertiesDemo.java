package com.tutorial.spring.springboot.customproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customproperties")
public class CustomPropertiesDemo {
	
	//injecting properties from application.properties file
	
	private String className = "CustomPropertiesDemo";
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	@GetMapping("/show")
	public String showCustomProperties() {
		return "Coach Name = "+coachName+" | Team Name = "+teamName;
	}
	
}
