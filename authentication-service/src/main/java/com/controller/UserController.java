package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User registeredUser=userService.registerUser(user);
		return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password){
		Optional<User> foundUser=userService.loginUser(email, password);
		if(foundUser.isPresent()) {
			return new ResponseEntity<>("Login Successful", HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
	}
}
