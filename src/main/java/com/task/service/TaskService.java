package com.task.service;

import com.task.dto.ResponseDto;
import com.task.dto.TaskRequestDto;

public interface TaskService {

	ResponseDto saveTask(TaskRequestDto requestDto);

	ResponseDto updateTask(TaskRequestDto requestDto);

	ResponseDto getAllTasks();

	ResponseDto getByTaskId(Long taskId);

	ResponseDto getAllTaskWithUserData();

	ResponseDto getByTaskIdWithUserData(Long taskId);

	ResponseDto getAllTaskByUserId(Long userId);

}
