package com.task.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.task.dto.ResponseDto;
import com.task.entity.User;
import com.task.repository.UserRepository;
import com.task.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	@CachePut(value = "users", key = "#user.id")
	@CacheEvict(value = "users", key = "'allUsers'", beforeInvocation = true)
	public ResponseDto saveUser(User user) {
		try {
			user.setCreatedOn(new Date());
			user.setUpdatedOn(new Date());
			userRepository.save(user);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	@Cacheable(value = "users", key = "'allUsers'")
	public ResponseDto getAllUsers() {
		try {
			List<User> userList = userRepository.findAll();
			return new ResponseDto(HttpStatus.OK.value(), userList, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	@Cacheable(value = "users", key = "#userId")
	public ResponseDto getByUserId(Long userId) {
		try {
			Optional<User> user = userRepository.findById(userId);
			return new ResponseDto(HttpStatus.OK.value(), user.get(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	@CachePut(value = "users", key = "#user.id")
	public ResponseDto updateUser(User user) {
		try {
			user.setUpdatedOn(new Date());
			userRepository.save(user);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

}
