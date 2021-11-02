package com.iiht.training.college.exceptions;

public class LecturerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LecturerNotFoundException() {
		super();
	}

	public LecturerNotFoundException(String message) {
		super(message);
	}

}
