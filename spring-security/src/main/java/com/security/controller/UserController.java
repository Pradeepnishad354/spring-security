package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUser(){
		
		return this.userService.getAllUser(); 
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username){
		
		return this.userService.getUser(username);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}

}
