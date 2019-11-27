package com.tutorial.spring.springboot.fileupload.restController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.spring.springboot.fileupload.entity.User;
import com.tutorial.spring.springboot.fileupload.logger.LoggerImpl;
import com.tutorial.spring.springboot.fileupload.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	LoggerImpl logger = new LoggerImpl(LoggerFactory.getLogger(UserController.class));
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public List<User> getUsers(@RequestHeader("Request-Id") String requestId) {
		logger.info(requestId,"Get Request has been received for getUsers");
		return userService.findAll();
	}
	
	@GetMapping("/{userId}")
	public User findUser(@PathVariable long userId, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId,"Get Request has been received for findUser with userId ="+userId);
		return userService.findById(userId);
	}
	
	@PostMapping("/")
	public void addUser(@RequestBody User user, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId,"Post Request has been received for addUser");
		logger.info(requestId,"User = "+user);
		userService.save(user);
	}
	
	@PutMapping("/")
	public HttpStatus updateUser(@RequestBody User user, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId,"Put Request has been received for updateUser");
		logger.info(requestId,"User = "+user);
		if(userService.update(user)) {
			logger.info(requestId,"User with userId="+user.getId()+" has been updated successfully.");
			return HttpStatus.OK;
		}
		else {
			logger.error(requestId,"User with userId +"+user.getId()+" has not been updated successfully.");
			return HttpStatus.NOT_MODIFIED;
		}
			
	}
	
	@DeleteMapping("/{userId}")
	public HttpStatus deleteUser(@PathVariable("userId") Long userId, @RequestHeader("Request-Id") String requestId) {
		logger.info(requestId,"Delete Request has been received for deleteUser");
		
		if(userService.deleteById(userId)) {
			logger.info(requestId,"User with userId ="+userId +" has been deleted successfully.");
			return HttpStatus.OK;
		}else {
			logger.error(requestId,"User with userId="+userId+" has not been deleted successfully.");
			return HttpStatus.NOT_FOUND;
		}
	}
}
