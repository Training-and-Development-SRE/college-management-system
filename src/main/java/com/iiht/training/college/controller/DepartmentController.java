package com.iiht.training.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.college.dto.DepartmentDto;
import com.iiht.training.college.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDto> registerDepartment(@RequestBody DepartmentDto departmentDto) {
		departmentService.registerDepartment(departmentDto);
		return ResponseEntity.ok(departmentDto);
	}

	@PutMapping
	public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto) {
		departmentService.updateDepartment(departmentDto);
		return ResponseEntity.ok(departmentDto);
	}

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long departmentId) {
		DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(departmentDto);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
		List<DepartmentDto> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}
}
