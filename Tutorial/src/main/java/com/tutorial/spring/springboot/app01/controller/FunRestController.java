package com.tutorial.spring.springboot.app01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app01")
public class FunRestController {
	
	@GetMapping("/")
	public String welcome() {
		return "Hello to app01";
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "do gyming daily";
	}
	
	@GetMapping("/tabs")
	public String tabs() {
		return ">> in tabs";
	}
}