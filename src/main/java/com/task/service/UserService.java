package com.task.service;

import com.task.dto.ResponseDto;
import com.task.entity.User;

public interface UserService {

	ResponseDto saveUser(User user);

	ResponseDto getAllUsers();

	ResponseDto getByUserId(Long userId);

	ResponseDto updateUser(User user);
}
