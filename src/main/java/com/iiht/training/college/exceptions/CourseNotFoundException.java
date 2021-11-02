package com.iiht.training.college.exceptions;

public class CourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CourseNotFoundException() {
		super();
	}

	public CourseNotFoundException(String message) {
		super(message);
	}

}