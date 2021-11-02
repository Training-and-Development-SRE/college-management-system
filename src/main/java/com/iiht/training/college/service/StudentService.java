package com.iiht.training.college.service;

import java.util.List;

import com.iiht.training.college.dto.StudentDto;

public interface StudentService {

	public StudentDto registerStudent(StudentDto studentDto);

	public StudentDto updateStudent(StudentDto studentDto);

	public Boolean deleteStudent(Long studentId);

	public StudentDto getStudentbyId(Long studentId);

	public List<StudentDto> getAllStudents();
}
