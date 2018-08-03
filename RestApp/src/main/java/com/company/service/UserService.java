package com.company.service;

import java.util.List;

import com.company.domain.UserDTO;
import com.company.entity.User;

public interface UserService {
	
	void saveUser(UserDTO userDTO);
	
	UserDTO findUserById(Long id);
	
	List<UserDTO> findAllUsers();
	
	UserDTO findByEmail(String email);
}
