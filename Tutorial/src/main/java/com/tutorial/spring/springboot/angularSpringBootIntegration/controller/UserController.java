package com.tutorial.spring.springboot.angularSpringBootIntegration.controller;

import com.tutorial.spring.springboot.angularSpringBootIntegration.entity.User;
import com.tutorial.spring.springboot.angularSpringBootIntegration.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("myController")
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("tutorial/spring/springboot/angularSpring")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserController() {
		
	}
	
	
	@GetMapping("/users")
	public List<User> getUsers(){
		System.out.println("getUsers");
		logger.debug("getUsers");
		
		List<User> users = (List<User>) userRepository.findAll();
		System.out.println("users = "+users);
		logger.debug("users = "+users);
		return users;
	}
	
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
