package com.tutorial.spring.springboot.thymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/thymeleaf")
public class ThymeleafRestController {
	
	@GetMapping("/")
	public String sayHello(Model model) {
		model.addAttribute("date", new Date());
		return "helloworld";
	}
}
