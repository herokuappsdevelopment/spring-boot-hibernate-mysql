package com.datasys.springboothibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasys.springboothibernate.dao.PersonDao;
import com.datasys.springboothibernate.model.Person;

@RestController
public class PersonController {

	@Autowired
	private PersonDao dao;
	
	@PostMapping(value="/savePerson")
	public String savePerson(@RequestBody Person person)
	{
		dao.saveUser(person);
		return "success!!";
	}
}
