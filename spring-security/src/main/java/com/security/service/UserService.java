package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.model.User;

@Service
public class UserService {
	
	List<User> list=new ArrayList<>();
	public UserService() {
		
		list.add(new User("pradeep","1234","pradeepnishad354@gmail.com"));
		list.add(new User("pritesh","12345","pritesh123@gmail.com"));
		list.add(new User("abhishek","123456","abhishek123@gmail.com"));
		
	}
	//get all user
	public List<User> getAllUser(){
		
		return list;
	}
	
	//get Single user
	public User getUser(String username) {
	
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	// add user
	public User addUser(User user) {
		
		this.list.add(user);
		return user;
	}

}
