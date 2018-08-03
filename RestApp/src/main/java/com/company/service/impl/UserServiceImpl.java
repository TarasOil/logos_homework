package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.UserDTO;
import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import com.company.service.utils.ObjectMapperUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveUser(UserDTO userDTO) {
		userRepository.save(modelMapper.map(userDTO, User.class));
		
	}

	@Override
	public UserDTO findUserById(Long id) {
		return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
	}

	@Override
	public List<UserDTO> findAllUsers() {
		return modelMapper.mapAll(userRepository.findAll(), UserDTO.class);
	}

	@Override
	public UserDTO findByEmail(String email) {
		return modelMapper.map(userRepository.findByEmail(email), UserDTO.class);
	}
	
	
}
