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

import com.iiht.training.college.dto.StudentDto;
import com.iiht.training.college.service.StudentService;


@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<StudentDto> registerStudent(@RequestBody StudentDto studentDto) {
		studentService.registerStudent(studentDto);
		return ResponseEntity.ok(studentDto);
	}

	@PutMapping
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
		studentService.updateStudent(studentDto);
		return ResponseEntity.ok(studentDto);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long studentId) {
		StudentDto studentDto = studentService.getStudentbyId(studentId);
		return ResponseEntity.ok(studentDto);
	}

	@GetMapping
	public ResponseEntity<List<StudentDto>> getAllStudent() {
		List<StudentDto> students = studentService.getAllStudents();
		return ResponseEntity.ok(students);
	}
}
