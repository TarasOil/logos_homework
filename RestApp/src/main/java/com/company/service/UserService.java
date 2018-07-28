package com.company.service;

import java.util.List;

import com.company.entity.User;

public interface UserService {
	
	void saveUser(User user);
	
	User findUserById(Long id);
	
	List<User> findAllUsers();
}
