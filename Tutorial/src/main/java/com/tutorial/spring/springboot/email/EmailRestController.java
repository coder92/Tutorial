package com.tutorial.spring.springboot.email;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring/springboot/email")
public class EmailRestController {
	
	@Autowired
	SendEmailApplication obj;
	
	
	
	@GetMapping("/1")
	public void sendEmailWithoutAttachment() {
		try {
			obj.sendEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/2")
	public void sendEmailWithAttachment() {
		try {
			obj.sendEmailWithAttachment();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
