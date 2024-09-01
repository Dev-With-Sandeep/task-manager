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
import com.task.entity.Role;
import com.task.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/v1/save")
	public ResponseEntity<?> saveRole(@RequestBody Role role) {
		ResponseDto response = roleService.saveRole(role);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/get/all/roles")
	public ResponseEntity<?> getAll() {
		ResponseDto response = roleService.getAllRoles();
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@GetMapping("/v1/get/by/roleId")
	public ResponseEntity<?> getByRoleId(@RequestParam("roleId") Integer roleId) {
		ResponseDto response = roleService.getByRoleId(roleId);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/update")
	public ResponseEntity<?> updateRole(@RequestBody Role role) {
		ResponseDto response = roleService.updateRole(role);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
}
