package com.mycompany.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.dao.UserDao;
import com.mycompany.model.User;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getByEmail(username);
		
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        return new SecurityUserPrincipal(user);
	}
}
