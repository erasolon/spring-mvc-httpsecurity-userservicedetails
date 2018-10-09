package com.erasolon.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erasolon.entity.Credentials;


/**
 * @author Emile
 * 
 * 25/08/2018
 */

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public EntityManagerFactory  entityManagerFactory;
	
	
	public Credentials findByUsername(String username) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Credentials> q = cb.createQuery(Credentials.class);
		Root<Credentials> c = q.from(Credentials.class);		
		ParameterExpression<String> paramUsername = cb.parameter(String.class);	
		q.select(c);
		
		q.where(cb.equal(c.get("username"), paramUsername));
		 TypedQuery<Credentials> query = entityManager.createQuery(q);
		 query.setParameter(paramUsername, username);
		 
		 return query.getSingleResult();
		
	}
	
}
