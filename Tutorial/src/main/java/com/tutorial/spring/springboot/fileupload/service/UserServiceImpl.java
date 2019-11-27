package com.tutorial.spring.springboot.fileupload.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Service;
import com.tutorial.spring.springboot.fileupload.entity.User;

@Service
public class UserServiceImpl implements UserService{

	Map<Long, User> userDB = new HashMap<Long, User>();
	
	
	//instance block
	//adding one default user
	{
		User user = new User();
		user.setAge(27);
		user.setFirstName("Ankit");
		user.setLastName("Dixit");
		user.setId(1);
		userDB.put(user.getId(), user);
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		
		for(Long id: userDB.keySet()) {
			users.add(userDB.get(id));
		}
		
		return users;
	}

	@Override
	public User findById(long id) {
		return userDB.get(id);
	}

	@Override
	public void save(User user) {
		Random r = new Random();
		
		while(true) {
			long id = r.nextLong();
			if(id<0)
				id *=-1;
			//System.out.println("id="+id);
			if(userDB.get(id)==null) {
				user.setId(id);
				userDB.put(id, user);
				System.out.println(userDB);
				break;
			}
		}
	}

	@Override
	public boolean deleteById(long id) {
		return (userDB.remove(id)!=null)?true:false;
	}

	@Override
	public boolean update(User user) {
		if(userDB.get(user.getId())!=null) {
			userDB.put(user.getId(), user);
			return true;
		}
		
		return false;
	}
}
