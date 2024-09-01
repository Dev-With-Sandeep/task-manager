package com.task.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.task.dto.ResponseDto;
import com.task.entity.Department;
import com.task.repository.DepartmentRepository;
import com.task.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public ResponseDto saveDepartment(Department department) {
		try {
			department.setIsActive(true);
			departmentRepository.save(department);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getAllDepartments() {
		try {
			List<Department> departmentList = departmentRepository.findAll();
			return new ResponseDto(HttpStatus.OK.value(), departmentList, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto getByDepartmentId(Integer departmentId) {
		try {
			Optional<Department> department = departmentRepository.findById(departmentId);
			return new ResponseDto(HttpStatus.OK.value(), department.get(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

	@Override
	public ResponseDto updateDepartment(Department department) {
		try {
			departmentRepository.save(department);
			return new ResponseDto(HttpStatus.OK.value(), null, "Success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDto(HttpStatus.BAD_REQUEST.value(), null, "Something went wrong");
		}
	}

}
