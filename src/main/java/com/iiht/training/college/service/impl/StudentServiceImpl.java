package com.iiht.training.college.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.college.dto.StudentDto;
import com.iiht.training.college.entity.Student;
import com.iiht.training.college.exceptions.StudentNotFoundException;
import com.iiht.training.college.repository.StudentRepository;
import com.iiht.training.college.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDto registerStudent(StudentDto studentDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		studentRepository.save(student);
		return studentDto;
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		studentRepository.save(student);
		return studentDto;
	}

	@Override
	public Boolean deleteStudent(Long studentId) {
		StudentDto studentDto = getStudentbyId(studentId);
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		studentRepository.delete(student);
		return true;
	}

	@Override
	public StudentDto getStudentbyId(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (student.isPresent()) {
			StudentDto studentDto = new StudentDto();
			BeanUtils.copyProperties(student.get(), studentDto);
			return studentDto;
		} else {
			throw new StudentNotFoundException("Student with id " + studentId + " does not exists");
		}
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : students) {
			StudentDto studentDto = new StudentDto();
			BeanUtils.copyProperties(student, studentDto);
			studentDtos.add(studentDto);
		}
		return studentDtos;
	}

}
