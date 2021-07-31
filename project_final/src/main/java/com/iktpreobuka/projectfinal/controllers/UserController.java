package com.iktpreobuka.projectfinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.projectfinal.entities.UserEntity;
import com.iktpreobuka.projectfinal.repositories.UserRepository;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public UserEntity createUser(@RequestParam String username, @RequestParam String password) {
		UserEntity user = new UserEntity();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
		return user;
	}
}
