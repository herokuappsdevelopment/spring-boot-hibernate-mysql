package com.datasys.springboothibernate.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.datasys.springboothibernate.entity.Users;

@NoRepositoryBean
public interface CustomRepository {
	
	List<Users> getAllUsers();
	
	List<Users> getAllUserById(int uid);
	
}
