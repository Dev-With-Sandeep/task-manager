package com.task.service;

import com.task.dto.ResponseDto;
import com.task.entity.Department;

public interface DepartmentService {

	ResponseDto saveDepartment(Department department);

	ResponseDto getAllDepartments();

	ResponseDto getByDepartmentId(Integer departmentId);

	ResponseDto updateDepartment(Department department);
}
