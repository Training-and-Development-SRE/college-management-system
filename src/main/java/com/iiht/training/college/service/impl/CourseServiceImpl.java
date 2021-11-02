package com.iiht.training.college.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.college.dto.CourseDto;
import com.iiht.training.college.entity.Course;
import com.iiht.training.college.exceptions.CourseNotFoundException;
import com.iiht.training.college.repository.CourseRepository;
import com.iiht.training.college.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseDto registerCourse(CourseDto courseDto) {
		Course course = new Course();
		BeanUtils.copyProperties(courseDto, course);
		courseRepository.save(course);
		return courseDto;
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto) {
		Course course = new Course();
		BeanUtils.copyProperties(courseDto, course);
		courseRepository.save(course);
		return courseDto;
	}

	@Override
	public Boolean deleteCourse(Long courseId) {
		CourseDto courseDto = getCourseById(courseId);
		Course course = new Course();
		BeanUtils.copyProperties(courseDto, course);
		courseRepository.delete(course);
		return true;
	}

	@Override
	public CourseDto getCourseById(Long courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if (course.isPresent()) {
			CourseDto courseDto = new CourseDto();
			BeanUtils.copyProperties(course.get(), courseDto);
			return courseDto;
		} else {
			throw new CourseNotFoundException("The course with id " + courseId + " does not exists");
		}
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		List<CourseDto> courseDtos = new ArrayList<>();
		for (Course course : courses) {
			CourseDto courseDto = new CourseDto();
			BeanUtils.copyProperties(course, courseDto);
			courseDtos.add(courseDto);
		}
		return courseDtos;
	}

}
