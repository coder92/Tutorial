package com.tutorial.spring.springboot.fileupload.service;

import java.util.List;
import com.tutorial.spring.springboot.fileupload.entity.User;


public interface UserService {
	
	public List<User> findAll();
	
	public void save(User user);
	
	public boolean deleteById(long id);

	public User findById(long id);
	
	public boolean update(User user);
}
