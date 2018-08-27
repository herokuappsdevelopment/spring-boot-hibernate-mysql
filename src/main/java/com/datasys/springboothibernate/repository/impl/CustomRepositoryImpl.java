package com.datasys.springboothibernate.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.datasys.springboothibernate.entity.Users;
import com.datasys.springboothibernate.repository.CustomRepository;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Users> getAllUsers() {
		List<Users> users =  (List<Users>)entityManager.createStoredProcedureQuery("fetch_all_users").getResultList();
		return users;
	}

	@Override
	public List<Users> getAllUserById(int uid) {
		
		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("fetch_userbyid");
		storedProcedure.registerStoredProcedureParameter("uid", Integer.class, ParameterMode.IN);
		storedProcedure.setParameter("uid", uid);
		return storedProcedure.getResultList();
	}

}
