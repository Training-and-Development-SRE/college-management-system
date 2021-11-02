package com.iiht.training.college.service;

import java.util.List;

import com.iiht.training.college.dto.CourseDto;

public interface CourseService {

	public CourseDto registerCourse(CourseDto courseDto);

	public CourseDto updateCourse(CourseDto courseDto);

	public Boolean deleteCourse(Long courseId);

	public CourseDto getCourseById(Long courseId);

	public List<CourseDto> getAllCourses();
}
