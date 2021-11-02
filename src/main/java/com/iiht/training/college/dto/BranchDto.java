package com.iiht.training.college.dto;

public class BranchDto {

	private Long branchId;
	private String branchName;
	private String branchStrength;
	private String coordinator;
	private Integer studentEnrolled;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchStrength() {
		return branchStrength;
	}

	public void setBranchStrength(String branchStrength) {
		this.branchStrength = branchStrength;
	}

	public String getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}

	public Integer getStudentEnrolled() {
		return studentEnrolled;
	}

	public void setStudentEnrolled(Integer studentEnrolled) {
		this.studentEnrolled = studentEnrolled;
	}

}
