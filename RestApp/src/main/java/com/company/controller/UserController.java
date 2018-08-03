package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.UserDTO;
import com.company.entity.User;
import com.company.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO) {
		userService.saveUser(userDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> userDTOs = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long id) {
		UserDTO userDTO = userService.findUserById(id);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Void> editUser(@PathVariable("userId") Long id, @RequestBody UserDTO userDTO) {
		UserDTO user = userService.findUserById(id);
		if(user != null) {
			userDTO.setId(user.getId());
			userService.saveUser(userDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/email")
	public ResponseEntity<UserDTO> getUserByEmail(@RequestParam("email") String email) {
		return new ResponseEntity<UserDTO>(userService.findByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/checkemail")
	public ResponseEntity<Boolean> checktUserByEmail(@RequestParam("email") String email) {
		if(userService.findByEmail(email) != null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.FOUND);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		
	}
}
