package com.iiht.training.college.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.college.dto.DepartmentDto;
import com.iiht.training.college.entity.Department;
import com.iiht.training.college.exceptions.DepartmentNotFoundException;
import com.iiht.training.college.repository.DepartmentRepository;
import com.iiht.training.college.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Override
	public DepartmentDto registerDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		BeanUtils.copyProperties(departmentDto, department);
		repository.save(department);
		return departmentDto;
	}

	@Override
	public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		BeanUtils.copyProperties(departmentDto, department);
		repository.save(department);
		return departmentDto;
	}

	@Override
	public Boolean deleteDepartment(Long departmentId) {
		DepartmentDto departmentDto = getDepartmentById(departmentId);
		Department department = new Department();
		BeanUtils.copyProperties(departmentDto, department);
		repository.delete(department);
		return true;
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
		Optional<Department> department = repository.findById(departmentId);
		if (department.isPresent()) {
			DepartmentDto departmentDto = new DepartmentDto();
			BeanUtils.copyProperties(department.get(), departmentDto);
			return departmentDto;
		} else {
			throw new DepartmentNotFoundException("The Department with id " + departmentId + " does not exists");
		}

	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		List<Department> departments = repository.findAll();
		List<DepartmentDto> departmentDtos = new ArrayList<>();
		for (Department department : departments) {
			DepartmentDto departmentDto = new DepartmentDto();
			BeanUtils.copyProperties(department, departmentDto);
			departmentDtos.add(departmentDto);
		}
		return departmentDtos;
	}

}
