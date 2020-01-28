package com.mycompany.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mycompany.model.AbstractEntity;

public abstract class AbstractDao<T extends AbstractEntity>{

	private Class<T> type;
	
	protected AbstractDao(Class<T> type) {
		super();
		this.type = type;
	}

	@PersistenceContext
    private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public T find(Long id) {
		return id == null ? null : getEntityManager().find(type, id);
	}
	
	public T getReference(Long id) {
		return getEntityManager().getReference(type, id);
	}
	
	public void persist(T entity) {
		getEntityManager().persist(entity);
	}
	
	public void persistAll(Collection<T> entities) {
		for (T entity : entities) {
			getEntityManager().persist(entity);
		}
	}
	
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}
	
	public void removeList(List<T> entities) {
		if (entities == null) {
			return;
		}
		for (T entity : entities) {
			remove(entity);
		}
	}
	
	public void detach(T entity) {
		getEntityManager().detach(entity);
	}
	
	public T merge(T entity) {
		return getEntityManager().merge(entity);
	}
	
	protected T getSingleResultOrNull(TypedQuery<T> typedQuery) {
		try {
			return typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}		
	}
	
	protected Object getSingleResultOrNull(Query query) {
		try {
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}		
	}	
	
	public List<T> list() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select e from ");
		sb.append(type.getSimpleName());
		sb.append(" e ");
		
		return createTypedQuery(sb.toString()).getResultList();
	}	
	
	protected TypedQuery<T> createTypedQuery(String sql) {
		return createTypedQuery(sql, type);
	}

	private <E> TypedQuery<E> createTypedQuery(String sql, Class<E> type) {
		return getEntityManager().createQuery(sql, type);
	}
	
	protected Query createNativeQuery(String sql) {
		return getEntityManager().createNativeQuery(sql);
	}
}
