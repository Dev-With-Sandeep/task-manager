package com.task.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.task.dto.ResponseDto;
import com.task.dto.TaskRequestDto;
import com.task.dto.TaskResponseDto;
import com.task.entity.Task;
import com.task.entity.TaskUserMapping;
import com.task.repository.TaskRepository;
import com.task.repository.TaskUserMappingRepository;
import com.task.service.TaskService;
import com.task.util.EntitySetter;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskUserMappingRepository taskUserMappingRepository;

	@Autowired
	private EntitySetter entitySetter;

	@Override
	public ResponseDto saveTask(@RequestBody TaskRequestDto requestDto) {
		try {
			Task task = entitySetter.taskRequestDtoToTaskEntity(requestDto);
			task.setIsActive(true);
			task.setCreatedOn(new Date());
			Task savedTask = taskRepository.save(task);
			TaskUserMapping taskUserMapping = entitySetter.taskRequestDtoToTaskUserMappingEntity(requestDto);
			taskUserMapping.setTask(savedTask);
			taskUserMapping.setIsActive(true);
			taskUserMapping.setCreatedOn(new Date());
			taskUserMappingRepository.save(taskUserMapping);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto updateTask(TaskRequestDto requestDto) {
		try {
			Task task = entitySetter.taskRequestDtoToTaskEntity(requestDto);
			task.setIsActive(true);
			task.setCreatedOn(new Date());
			Task savedTask = taskRepository.save(task);
			TaskUserMapping taskUserMapping = entitySetter.taskRequestDtoToTaskUserMappingEntity(requestDto);
			taskUserMapping.setTask(savedTask);
			taskUserMapping.setIsActive(true);
			taskUserMapping.setCreatedOn(new Date());
			taskUserMappingRepository.save(taskUserMapping);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getAllTasks() {
		try {
			List<Task> taskList = taskRepository.findAll();
			List<TaskResponseDto> taskResponseList = taskList.stream()
					.map(task -> entitySetter.taskEntityToTaskResponseDto(task)).collect(Collectors.toList());
			return new ResponseDto(HttpStatus.OK.value(), taskResponseList, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getByTaskId(Long taskId) {
		try {
			Optional<Task> task = taskRepository.findById(taskId);
			TaskResponseDto responseDto = entitySetter.taskEntityToTaskResponseDto(task.get());
			return new ResponseDto(HttpStatus.OK.value(), responseDto, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getAllTaskWithUserData() {
		try {
			List<TaskUserMapping> taskUserMappingList = taskUserMappingRepository.findAll();
			List<TaskResponseDto> taskResponseList = taskUserMappingList.stream()
					.map(task -> entitySetter.taskUserMappingEntityToTaskResponseDto(task))
					.collect(Collectors.toList());
			return new ResponseDto(HttpStatus.OK.value(), taskResponseList, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getByTaskIdWithUserData(Long taskId) {
		try {
			Optional<TaskUserMapping> task = taskUserMappingRepository.findByTask_Id(taskId);
			TaskResponseDto responseDto = entitySetter.taskUserMappingEntityToTaskResponseDto(task.get());
			return new ResponseDto(HttpStatus.OK.value(), responseDto, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getAllTaskByUserId(Long userId) {
		try {
			List<TaskUserMapping> taskUserMappingList = taskUserMappingRepository.findAllByAssignedTo_Id(userId);
			List<TaskResponseDto> taskResponseList = taskUserMappingList.stream()
					.map(task -> entitySetter.taskUserMappingEntityToTaskResponseDto(task))
					.collect(Collectors.toList());
			return new ResponseDto(HttpStatus.OK.value(), taskResponseList, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

}
