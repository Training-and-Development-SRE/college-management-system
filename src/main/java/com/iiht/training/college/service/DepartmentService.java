package com.iiht.training.college.service;

import java.util.List;

import com.iiht.training.college.dto.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto registerDepartment(DepartmentDto departmentDto);

	public DepartmentDto updateDepartment(DepartmentDto departmentDto);

	public Boolean deleteDepartment(Long departmentId);

	public DepartmentDto getDepartmentById(Long departmentId);

	public List<DepartmentDto> getAllDepartments();
}
