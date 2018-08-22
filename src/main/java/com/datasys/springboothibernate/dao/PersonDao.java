package com.datasys.springboothibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datasys.springboothibernate.model.Person;

@Repository
@Transactional
public class PersonDao {
	
		@Autowired
		private SessionFactory sessionFactory;

		private Session getSession() {
			Session session = sessionFactory.getCurrentSession();
			if(session == null) {
				session = sessionFactory.openSession();
			}
			return session;
		}
		
		
		
		public void saveUser(Person p) {
			getSession().save(p);
		}
		
		@SuppressWarnings("deprecation")
		public List<Person> getPersons(){
			return getSession().createCriteria(Person.class).list();
		}
}

