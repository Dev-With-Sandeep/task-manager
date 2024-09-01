package com.task.service;

import com.task.dto.ResponseDto;
import com.task.entity.Role;

public interface RoleService {

	ResponseDto saveRole(Role role);

	ResponseDto getAllRoles();

	ResponseDto getByRoleId(Integer roleId);

	ResponseDto updateRole(Role role);
}
