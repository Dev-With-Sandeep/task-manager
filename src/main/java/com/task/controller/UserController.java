package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.ResponseDto;
import com.task.entity.User;
import com.task.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/v1/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		ResponseDto response = userService.saveUser(user);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@GetMapping("/v1/get/all/users")
	public ResponseEntity<?> getAll() {
		ResponseDto response = userService.getAllUsers();
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@GetMapping("/v1/get/by/userId")
	public ResponseEntity<?> getByUserId(@RequestParam("userId") Long userId) {
		ResponseDto response = userService.getByUserId(userId);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		ResponseDto response = userService.updateUser(user);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

}
