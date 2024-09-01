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
import com.task.entity.Department;
import com.task.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/v1/save")
	public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
		ResponseDto response = departmentService.saveDepartment(department);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/get/all/departments")
	public ResponseEntity<?> getAll() {
		ResponseDto response = departmentService.getAllDepartments();
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@GetMapping("/v1/get/by/departmentId")
	public ResponseEntity<?> getByDepartmentId(@RequestParam("departmentId") Integer departmentId) {
		ResponseDto response = departmentService.getByDepartmentId(departmentId);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/update")
	public ResponseEntity<?> updateDepartment(@RequestBody Department department) {
		ResponseDto response = departmentService.updateDepartment(department);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
}
