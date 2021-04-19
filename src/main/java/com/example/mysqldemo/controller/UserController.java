package com.example.mysqldemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqldemo.entity.User;
import com.example.mysqldemo.service.IuserService;

@RestController
public class UserController {
	@Autowired
	private IuserService userService;
	@PostMapping("user")
	int createUser(@RequestBody User user){
		
		return userService.save(user);
	}
	
	@GetMapping("user")
	List<User> getusers() {
		return userService.getUsers();
	}

	@GetMapping("user/{name}")
List <User> getUser(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}
	@DeleteMapping("user/{id}")
	void getAllUsers(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
	}
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong. Please retry");
		}
	}

	@PutMapping("user/{id}")
	void updateUser(@RequestBody @Value(value = "") User user, BindingResult bindingResult,
			@PathVariable("id") Integer userId) {
		validateModel(bindingResult);
		user.setId(userId);
		userService.updateUser(user);
	}
}
