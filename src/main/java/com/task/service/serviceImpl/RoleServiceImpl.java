package com.task.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.task.dto.ResponseDto;
import com.task.entity.Role;
import com.task.repository.RoleRepository;
import com.task.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseDto saveRole(Role role) {
		try {
			roleRepository.save(role);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getAllRoles() {
		try {
			List<Role> roleList = roleRepository.findAll();
			return new ResponseDto(HttpStatus.OK.value(), roleList, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getByRoleId(Integer roleId) {
		try {
			Optional<Role> role = roleRepository.findById(roleId);
			return new ResponseDto(HttpStatus.OK.value(), role.get(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto updateRole(Role role) {
		try {
			roleRepository.save(role);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

}
