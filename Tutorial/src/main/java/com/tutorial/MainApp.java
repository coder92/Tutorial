package com.tutorial;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}


@RestController
@RequestMapping("")
class MainController
{
	ArrayList<String> tutorilUrls = new ArrayList<String>();
	
	{
		tutorilUrls.add("/spring/springboot/email");
		tutorilUrls.add("/spring/springboot/fileupload");
	}
	
	
	@GetMapping("/")
	public String welcome() {
		StringBuilder str = new StringBuilder("<h1>Welcome to Tutorials</h1>");
		str.append("<ul>");
		for(String s: tutorilUrls) {
			str.append("<li>").append(s).append("</li>");
		}
		str.append("</ul>");
		return str.toString();
	}
}