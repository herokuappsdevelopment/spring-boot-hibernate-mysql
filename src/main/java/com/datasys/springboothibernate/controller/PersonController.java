package com.datasys.springboothibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasys.springboothibernate.dao.PersonDao;
import com.datasys.springboothibernate.entity.Users;
import com.datasys.springboothibernate.model.Person;
import com.datasys.springboothibernate.repository.impl.CustomRepositoryImpl;

@RestController
public class PersonController {

	@Autowired
	private PersonDao dao;
	
	@Autowired
	private CustomRepositoryImpl customRepository;
	
	@PostMapping(value="/savePerson")
	public String savePerson(@RequestBody Person person)
	{
		dao.saveUser(person);
		return "success!!";
	}
	@GetMapping("/getAll")
	public List<Person> getALlPersons() {
		return dao.getPersons();
	}
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return customRepository.getAllUsers();
	}
	
	@GetMapping("/getUser/{uid}")
	public List<Users> getUserById(@PathVariable("uid") int userid) {
		return customRepository.getAllUserById(userid);
	}
	
}
