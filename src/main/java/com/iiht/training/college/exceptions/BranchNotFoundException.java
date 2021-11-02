package com.iiht.training.college.exceptions;

public class BranchNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BranchNotFoundException() {
		super();
	}

	public BranchNotFoundException(String message) {
		super(message);
	}

}
