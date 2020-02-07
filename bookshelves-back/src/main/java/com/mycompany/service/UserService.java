package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.UserDao;
import com.mycompany.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = false)
	public void create(User user) {
		user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
		userDao.persist(user);
	}

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userDao.list();
	}
}
