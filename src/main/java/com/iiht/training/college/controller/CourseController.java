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

import com.iiht.training.college.dto.CourseDto;
import com.iiht.training.college.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping
	public ResponseEntity<CourseDto> registerCourse(@RequestBody CourseDto courseDto) {
		courseService.registerCourse(courseDto);
		return ResponseEntity.ok(courseDto);
	}

	@PutMapping
	public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
		courseService.updateCourse(courseDto);
		return ResponseEntity.ok(courseDto);
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<Boolean> deleteCourse(@PathVariable Long courseId) {
		courseService.deleteCourse(courseId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDto> getCourseByid(@PathVariable Long courseId) {
		CourseDto courseDto = courseService.getCourseById(courseId);
		return ResponseEntity.ok(courseDto);
	}

	@GetMapping
	public ResponseEntity<List<CourseDto>> getAllCourses() {
		List<CourseDto> courses = courseService.getAllCourses();
		return ResponseEntity.ok(courses);
	}
}
