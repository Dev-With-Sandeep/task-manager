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
import com.task.dto.TaskRequestDto;
import com.task.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/v1/save")
	public ResponseEntity<?> saveTask(@RequestBody TaskRequestDto requestDto) {
		ResponseDto response = taskService.saveTask(requestDto);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/get/all/tasks")
	public ResponseEntity<?> getAll() {
		ResponseDto response = taskService.getAllTasks();
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@GetMapping("/v1/get/by/taskId")
	public ResponseEntity<?> getByTaskId(@RequestParam("taskId") Long taskId) {
		ResponseDto response = taskService.getByTaskId(taskId);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@PostMapping("/v1/update")
	public ResponseEntity<?> updateTask(@RequestBody TaskRequestDto requestDto) {
		ResponseDto response = taskService.updateTask(requestDto);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
	
	@PostMapping("/v1/get/all/tasks/with/user/data")
	public ResponseEntity<?> getAllTaskWithUserData() {
		ResponseDto response = taskService.getAllTaskWithUserData();
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
	
	@GetMapping("/v1/get/by/taskId/with/user/data")
	public ResponseEntity<?> getByTaskIdWithUserData(@RequestParam("taskId") Long taskId) {
		ResponseDto response = taskService.getByTaskIdWithUserData(taskId);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

	@GetMapping("/v1/get/all/task/by/user/id")
	public ResponseEntity<?> getAllTaskByUserId(@RequestParam("userId") Long userId) {
		ResponseDto response = taskService.getAllTaskByUserId(userId);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}

}
