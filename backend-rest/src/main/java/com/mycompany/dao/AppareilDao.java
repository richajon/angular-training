package com.mycompany.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.model.Appareil;

@Repository
public class AppareilDao extends AbstractDao<Appareil> {

	protected AppareilDao() {
		super(Appareil.class);
	}
}
