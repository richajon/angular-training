package com.mycompany.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.AppareilDao;
import com.mycompany.model.Appareil;

@Service
public class AppareilService {

	@Autowired
	private AppareilDao appareilDao;
	
	public List<Appareil> getAppareilsList() {
		return appareilDao.list();
	}
	
	public Appareil getAppareilById(Long id) {
		return appareilDao.find(id);
	}

	@Transactional(readOnly = false)
	public void add(Appareil appareil) {
		appareilDao.merge(appareil);
		appareilDao.persist(appareil);
	}

	/**
	 * add new appareils
	 * update existing appareils
	 * remove non existing appareils
	 * 
	 * @param appareils
	 */
	@Transactional(readOnly = false)
	public void updateAppareils(List<Appareil> appareils) {
		
		// fetch appareils from DB
		List<Appareil> dbAppareils = appareilDao.list();
		
		// store into a id-appareil map
		Map<Long, Appareil> dbAppareilsMap = dbAppareils.stream().collect(Collectors.toMap(Appareil::getId, Function.identity()));

		for (Appareil appareil : appareils) {
			if (appareil.getId() == null) {
				// is new
				Appareil a = new Appareil();
				
				a.setName(appareil.getName());
				a.setStatus(appareil.getStatus());
				
				// save change to db
				appareilDao.persist(a);
			} else {
				// update
				Appareil a = dbAppareilsMap.get(appareil.getId());
				
				if (a != null) {
					a.setName(appareil.getName());
					a.setStatus(appareil.getStatus());
				}
				
				// save change to db
				appareilDao.persist(a);
				
				// remove from DB map
				dbAppareilsMap.remove(appareil.getId());
			}
		}
		
		// remaining items in the map do not exist anymore so remove them from DB
		for (Appareil a : dbAppareilsMap.values()) {
			appareilDao.remove(a);
		}
	}
}
