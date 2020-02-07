package com.mycompany.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mycompany.model.User;

@Repository
public class UserDao extends AbstractDao<User> {

	protected UserDao() {
		super(User.class);
	}
	
	public User getByEmail(String email) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select u from User u where u.email = :email ");
		
		TypedQuery<User> query = createTypedQuery(sql.toString());
		query.setParameter("email", email);
		return getSingleResultOrNull(query);
	}
}
