package com.task.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.task.dto.TaskRequestDto;
import com.task.dto.TaskResponseDto;
import com.task.entity.Task;
import com.task.entity.TaskUserMapping;
import com.task.entity.User;

@Component
public class EntitySetter {

	public Task taskRequestDtoToTaskEntity(TaskRequestDto requestDto) {
		if (requestDto == null) {
			return null;
		}
		return new Task(null, requestDto.getName(), requestDto.getDescription(), requestDto.getTaskDate(), null, null,
				null);
	}

	public TaskUserMapping taskRequestDtoToTaskUserMappingEntity(TaskRequestDto requestDto) {
		if (requestDto == null) {
			return null;
		}
		return new TaskUserMapping(requestDto.getId(), new User(requestDto.getAssignedTo()),
				new User(requestDto.getAssignedBy()), null, requestDto.getIsImportant(), new Date(), null);
	}

	public TaskResponseDto taskUserMappingEntityToTaskResponseDto(TaskUserMapping entity) {
		if (entity == null) {
			return null;
		}
		return new TaskResponseDto(entity.getId(), entity.getTask().getId(), entity.getTask().getName(),
				entity.getTask().getDescription(), entity.getTask().getTaskDate(), entity.getAssignedTo().getName(),
				entity.getAssignedBy().getName(), entity.getIsActive());
	}

	public TaskResponseDto taskEntityToTaskResponseDto(Task entity) {
		if (entity == null) {
			return null;
		}
		return new TaskResponseDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getTaskDate(),
				entity.getIsActive());
	}
}
