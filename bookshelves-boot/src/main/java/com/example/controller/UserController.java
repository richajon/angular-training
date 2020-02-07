package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired()
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> index() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody(required = true) User user) {
		userRepository.save(user);
	}
}
