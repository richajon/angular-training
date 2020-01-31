package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired()
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		userRepository.findById(1L);
		return "12312";
	}
}
